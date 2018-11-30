package com.base.xwg.mvp.utils

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.base.xwg.mvp.MyApplication
import com.base.xwg.mvp.R

/**
 *
 * @author xwg on 2018/8/2.
 */
class ToastUtils {
    lateinit var  context:Context
    lateinit var  toast:Toast
    lateinit var msg :String
    constructor()
    constructor(context :Context){
        this.context= context
    }
    companion object {
        lateinit var  td: ToastUtils
        fun show(str :String){
            if(td ==null){
                td = ToastUtils(MyApplication.getInstance())
            }
            td.setText(str)
            td.create().show()
        }
        fun show(resId:Int){
            show(MyApplication.getInstance().resources.getString(resId))
        }
        fun shortShow(text :String){
            if(td ==null){
                td = ToastUtils()
            }
            td.setText(text)
        }
    }

    fun   create():Toast{
        val contentView =View.inflate(context, R.layout.dialog_toast,null)
        val  tvMsg = contentView.findViewById(R.id.tv_toast_msg) as TextView
        toast= Toast(context)
        toast.view=contentView
        toast.setGravity(Gravity.CENTER,0,0)
        toast.duration=Toast.LENGTH_LONG
        tvMsg.setText(msg)
        return toast
    }
    fun createShort():Toast{
        val contentView = View.inflate(context, R.layout.dialog_toast,null)
        val tvMsg = contentView.findViewById<TextView>(R.id.tv_toast_msg)
        toast= Toast(context)
        toast.view= contentView
        toast.setGravity(Gravity.CENTER,0,0)
        toast.duration=Toast.LENGTH_SHORT
        tvMsg.setText(msg)
        return toast
    }
    fun show(){
        if(toast!=null){
            toast.show()
        }
    }
    fun setText(text:String){
        msg = text
    }
}