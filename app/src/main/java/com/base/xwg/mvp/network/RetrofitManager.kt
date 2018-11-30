package com.base.xwg.mvp.network

import com.base.xwg.mvp.BuildConfig
import com.base.xwg.mvp.utils.Constant
import com.base.xwg.mvp.utils.SystemUtil
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 *
 * @author xwg on 2018/8/13.
 */
class RetrofitManager {
    lateinit var mRetrofit: Retrofit
    companion object {
        val DEFAULT_TIMEOUT = 5

        val mRetrofitManager: RetrofitManager by lazy { RetrofitManager() }
        fun getInstance(): RetrofitManager {
            return mRetrofitManager
        }
    }

    private constructor() {
        val builder = OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor)
        }
        val chcheFile = File(Constant.PATH_CACHE)
        val cache = Cache(chcheFile, 1024 * 1024 * 50)
        val cacheInterceptor = Interceptor() { chain ->
            var request = chain.request()
            if (!SystemUtil.isNetworkConnect()) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build()
            }
            val response = chain.proceed(request)
            if (SystemUtil.isNetworkConnect()) {
                val maxAge = 0
                // 有网络时, 不缓存, 最大保存时长为0
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=$maxAge")
                        .removeHeader("Pragma")
                        .build()
            } else {
                // 无网络时，设置超时为4周
                val maxStale = 60 * 60 * 24 * 28
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                        .removeHeader("Pragma")
                        .build()
            }

            return@Interceptor response
        }

        builder.addNetworkInterceptor(cacheInterceptor)
        builder.addInterceptor(cacheInterceptor)
        builder.cache(cache)
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(20, TimeUnit.SECONDS)
        builder.writeTimeout(20, TimeUnit.SECONDS)
        builder.retryOnConnectionFailure(true)
        val mOkHttpClient = builder.build()
         mRetrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .client(mOkHttpClient)
                .build()
    }
    fun <T> create(service:Class<T>): T{
        return mRetrofit.create(service)
    }

}


