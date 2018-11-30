package com.base.xwg.mvp.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.Uri
import android.view.View
import com.base.xwg.mvp.MyApplication
import java.io.File
import java.io.FileOutputStream

/**
 *
 * @author xwg on 2018/8/13.
 */
class SystemUtil {
    companion object {
        fun isWifiConnected(): Boolean {
            val connectivityManage = MyApplication.getInstance().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val wifiInfo = connectivityManage.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            return wifiInfo != null
        }

        fun isMobileNetworkConnected(): Boolean {
            val connectivityManager = MyApplication.getInstance().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mobileNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            return mobileNetworkInfo != null
        }

        fun isNetworkConnect(): Boolean {
            val connectivityManager = MyApplication.getInstance().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return connectivityManager.getActiveNetworkInfo() != null

        }
       fun copyToClipBoard(context :Context ,text:String){
           val clipData= ClipData.newPlainText("url",text)
           val manager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
           manager.setPrimaryClip(clipData)
           ToastUtils.shortShow("已经复制到剪切板")

       }
        fun saveBitmapToFile(context:Context, url:String, bitmap: Bitmap, container: View, isShare:Boolean):Uri{
            val fileName = url.substring(url.lastIndexOf("/"),url.lastIndexOf("."))+".png"
            val fileDir =  File(Constant.PATH_DATA)
            if(!fileDir.exists()){
                fileDir.mkdir()
            }
            val imageFile = File(fileDir,fileName)
            val uri = Uri.fromFile(imageFile)
            if(isShare&& imageFile.exists()){
                return uri
            }
            val fos = FileOutputStream(imageFile)
        var isCompress=    bitmap.compress(Bitmap.CompressFormat.PNG,90,fos)
            if(isCompress){
//                Snack
            }
            return uri
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dp2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dp(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }
}