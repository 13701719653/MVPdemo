package com.base.xwg.mvp


/**
 *
 * @author xwg on 2018/8/3.
 */
    open class SingletonHolder<out T>(creator: ()->T) {
        private var creator: (() -> T)? = creator
        @Volatile private var instance: T? = null

        fun getInstance(): T {
            val i = instance
            if (i != null) {
                return i
            }

            return synchronized(this) {
                val i2 = instance
                if (i2 != null) {
                    i2
                } else {
                    val created = creator!!()
                    instance = created
                    creator = null
                    created
                }
            }
        }
    }
