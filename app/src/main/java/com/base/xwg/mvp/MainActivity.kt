package com.base.xwg.mvp;

import android.os.Bundle
import com.base.xwg.mvp.base.BaseActivity

class MainActivity : BaseActivity() {
     override fun getLayout(): Int {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun initEventAndData() {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun toggleOverridePendingTransition(): Boolean {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun getOverridePendingTransitionMode(): BaseActivity.TransitionMode {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun createPresenter() {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }
}
