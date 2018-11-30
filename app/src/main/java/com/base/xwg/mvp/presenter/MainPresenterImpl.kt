package com.base.xwg.mvp.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import com.base.xwg.mvp.api.AppVersionService
import com.base.xwg.mvp.base.BaseRxPresneter
import com.base.xwg.mvp.contact.MainContract
import com.base.xwg.mvp.network.RetrofitManager
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

@SuppressLint("ParcelCreator")
/**
 *
 * @author xwg on 2018/8/13.
 */

class  MainPresenterImpl : BaseRxPresneter<MainContract.View>,MainContract.Presenter, Parcelable {
    lateinit var  context: Context


//    @Inject
    constructor(context: Context) {
        this.context= context
    }
    override fun checkVersion(currentVersion: String) {
//        val observable= RetrofitManager.getInstance().create(AppVersionService.class).getVersion().map(HttpResu)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }


}