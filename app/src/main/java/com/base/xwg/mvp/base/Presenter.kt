package com.base.xwg.mvp.base

/**
 *
 * @author xwg on 2018/8/2.
 */
interface Presenter<T : BaseView> {

    fun attachView(view: T)
    fun detachView()
}