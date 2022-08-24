package com.qiudaozhang.core.common

import com.qiudaozhang.core.common.consts.StringPool

class R<T> {

    var code: Int = 0
    var message: String = StringPool.EMPTY
    var data: T? = null


    companion object {
        fun <T> suc(data: T): R<T> {
            val r = R<T>()
            r.message = StringPool.SUC
            r.data = data
            return r
        }
    }


}

//object R<T> {
//    fun <T>suc(data: T): R<T> {
//        val r = R<T>()
//        r.message = StringPool.SUC
//        r.data = data
//        return r
//    }
//}