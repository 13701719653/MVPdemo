package com.base.xwg.mvp.api

import com.base.xwg.mvp.BaseResponse
import com.base.xwg.mvp.model.bean.VersionBean
import retrofit2.http.GET
import rx.Observable

/**
 *
 * @author xwg on 2018/8/14.
 */
public interface AppVersionService {
    @GET("version")
    fun getVersion(): Observable<BaseResponse<VersionBean>>;
}