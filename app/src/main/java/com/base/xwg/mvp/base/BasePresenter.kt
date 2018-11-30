package com.base.xwg.mvp.base;

/**
 * @author xwg on 2018/8/9.
 */
open interface BasePresenter<T : BaseView> {
    /**
     * Binds presenter with a view when resumed. The Presenter will perform initialization here.
     *
     * @param view the view associated with this presenter
     */
    abstract fun takeView(view: T)

    /**
     * Drops the reference to the view when destroyed
     */
    abstract fun dropView()

}
