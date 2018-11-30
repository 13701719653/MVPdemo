package com.base.xwg.mvp.contact;

import com.base.xwg.mvp.base.BasePresenter;
import com.base.xwg.mvp.base.BaseView;
import com.base.xwg.mvp.model.bean.VersionBean

/**
 * @author xwg on 2018/8/13.
 */
public class MainContract {
      interface  View : BaseView{
        fun showUpdateDialog(bean: VersionBean)

    }
    interface  Presenter :BasePresenter<View>{
        fun checkVersion(currentVersion:String)
    }
}
