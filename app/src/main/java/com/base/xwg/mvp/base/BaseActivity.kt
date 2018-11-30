package com.base.xwg.mvp.base;

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.base.xwg.mvp.LoadingDialogFragment
import javax.inject.Inject

@SuppressLint("RestrictedApi")
open
/**
 * @author xwg on 2018/8/2.
 */
abstract  class BaseActivity: AppCompatActivity(), BaseView {
    @Inject
//    lateinit var   mPresenter:T
      lateinit var  mContext : Activity
//   lateinit var  mUnbinder :Unbinder

    enum class TransitionMode{
        LEFT,RIGHT,TOP,BOTTOM,SCALE,FADE
    }
    override fun showError(msg: String) {

    }
    override fun useNightMode(isNight: Boolean) {
    }

    lateinit var loadingDialog: LoadingDialogFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if()
    }

    abstract  fun   getLayout():Int
    abstract  fun  initEventAndData()
    abstract  fun toggleOverridePendingTransition():Boolean
    abstract  fun getOverridePendingTransitionMode(): TransitionMode
    abstract  fun createPresenter()
//    override fun showTipMsg(msg: String) {
//        ToastUtils.showTipMsg(msg)
//    }
//
//    override fun showTipMsg(msg: Int) {
//        ToastUtils.showTipMsg(msg)
//    }

//    override fun showLoading() {
//        if (loadingDialog == null) {
//            loadingDialog = LoadingDialogFragment()
//
//        }
//        loadingDialog.show(supportFragmentManager,"")
//        loadingDialog.setCancelable(true)
//    }
//
//    override fun hideLoading() {
//
//            val fragmentManager = getSupportFragmentManager()
//            if (fragmentManager != null) {
//                try {
//                    val data = fragmentManager!!.getFragments()
//                    val loadingDialogFragment = fragmentManager!!.findFragmentByTag("loadingDialog") as LoadingDialogFragment
//                    if (loadingDialogFragment == null && data.size > 0) {
//                        for (fragment in data) {
//                            if (fragment is LoadingDialogFragment) {
//                                (fragment as LoadingDialogFragment).dismissAllowingStateLoss()
//                            }
//                        }
//
//                    } else loadingDialogFragment?.dismissAllowingStateLoss()
//
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//
//        }
//    }

//    override fun invalidToken() {
//
//    }
//
//    override fun myFinish() {
//
//        finish();
//    }
}
