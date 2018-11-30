package com.base.xwg.mvp

/**
 *
 * @author xwg on 2018/8/2.
 */
class BaseResponse<T> {
    var code: Int = 0
    lateinit var message: String
    var data: T? = null
}