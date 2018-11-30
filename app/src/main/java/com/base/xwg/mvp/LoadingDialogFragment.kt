package com.base.xwg.mvp

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window

/**
 *
 * @author xwg on 2018/8/2.
 */
class LoadingDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog_style)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.dialog, container)
        return view
    }

    override fun onResume() {
        if (getDialog() != null && getDialog().window != null) {
            var window = getDialog().window
            var layoutParams = window.attributes;
            layoutParams.dimAmount = 0.47f
            window.attributes = layoutParams
        }
        super.onResume()
    }

    override fun show(manager: FragmentManager?, tag: String?) {
        try {
            if (manager != null) {
                manager.beginTransaction().remove(this).commit()
            }
            super.show(manager, tag)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}