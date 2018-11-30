package com.base.xwg.mvp.base

import rx.subscriptions.CompositeSubscription

/**
 *
 * @author xwg on 2018/8/13.
 */
open class BaseRxPresneter<T : BaseView> : BasePresenter<T> {
   var mView: T? = null
    lateinit var compositeSubscription: CompositeSubscription
    fun addSubScribe(subscription: CompositeSubscription) {
        if (compositeSubscription == null) {
            compositeSubscription = CompositeSubscription()
        }
        compositeSubscription.add(subscription)
    }

    fun unSubcribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe()
        }
    }

    override fun attachView(view: T) {
        this.mView= view
    }

    override fun detachView() {
        mView= null
        unSubcribe()
    }

}