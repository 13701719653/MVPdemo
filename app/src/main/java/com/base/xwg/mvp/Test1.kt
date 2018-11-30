package com.base.xwg.mvp

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 *
 * @author xwg on 2018/8/3.
 */
class Test1 : AppCompatActivity() {
    lateinit  var context:Context
    companion object :SingletonHolder<Context>(::Test1)


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
      var i =  getInstance()
    }

}