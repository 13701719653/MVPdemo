package com.base.xwg.mvp.network

/**
 *
 * @author xwg on 2018/8/14.
 */
class ApiException() : RuntimeException() {
    companion object {
        val  USER_NOT_EXIST=100
        val  WRONG_PASSWORD=101
        fun getApiExceptionMessage(code:Int){
            var message:String
            when (code){
                USER_NOT_EXIST->"用户不存在"
                WRONG_PASSWORD->"密码错误"
                else->"未知错误"
            }
        }
    }
    constructor(resultCode :Int):this(){
    }

}