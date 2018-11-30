package com.base.xwg.mvp.base

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View

/**
 *
 * @author xwg on 2018/8/6.
 */
class BaseViewHolder : RecyclerView.ViewHolder {
    lateinit var views: SparseArray<View>

    constructor(view: View) : super(view) {
        views = SparseArray()
    }

    fun <T : View> getView(viewId: Int): T {
        var view = views.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            views.put(viewId, view)
        }
        return view as T;
    }

    fun getRootView() : View
    {
        return itemView
    }
}