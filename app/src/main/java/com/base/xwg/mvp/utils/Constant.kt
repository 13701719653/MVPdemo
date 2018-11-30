package com.base.xwg.mvp.utils

import com.base.xwg.mvp.MyApplication
import java.io.File

/**
 *
 * @author xwg on 2018/8/13.
 */
class Constant {
    companion object {
        val BASE_URL="http://codeest.me/api/geeknews/";
        val PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
        val PATH_CACHE= PATH_DATA+"/NetCache"
    }
}