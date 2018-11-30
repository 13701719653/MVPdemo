package com.base.xwg.mvp.base;

import android.support.annotation.StringRes

/**
 * @author xwg on 2018/8/2.
 */
open interface BaseView {
//    fun showTipMsg(msg: String)
//    fun showTipMsg(@StringRes msg: Int)
//    fun showLoading()
//    fun hideLoading()
//    fun invalidToken()
//    fun myFinish()
    fun showError(msg :String)
    fun useNightMode(isNight : Boolean)
}
