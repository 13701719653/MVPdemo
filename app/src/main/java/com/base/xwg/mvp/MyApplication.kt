package com.base.xwg.mvp;

import android.app.Activity
import android.app.Application;
import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

/**
 * @author xwg on 2018/8/2.
 */
class MyApplication private constructor() : Application() {
    companion object {
         val instance :MyApplication by lazy{ MyApplication()}
        fun getInstance():Application{
            return instance
        }

    }
    lateinit var  allActivitys:  MutableSet<Activity>

    fun getReWatcher(context: Context): RefWatcher? {
        val application = context.applicationContext as MyApplication
        return application.getRefWatcher()
    }

    private var refWatcher: RefWatcher? = null

    fun getRefWatcher(): RefWatcher? {
        return refWatcher
    }

    override fun onCreate() {
        super.onCreate()
        refWatcher = LeakCanary.install(this)
    }

    fun addActivity(act :Activity){
        if(allActivitys==null){
            allActivitys= HashSet()
        }
        allActivitys.add(act)
    }
    fun removeActivity(act :Activity){
        if(allActivitys!=null){
            allActivitys.remove(act)
        }
    }
   fun exitApp(){
       if(allActivitys!=null){
           synchronized(allActivitys){

               for(act in allActivitys){
                   act.finish()
               }
           }
       }
       android.os.Process.killProcess(android.os.Process.myPid())
       System.exit(0)
   }
}
