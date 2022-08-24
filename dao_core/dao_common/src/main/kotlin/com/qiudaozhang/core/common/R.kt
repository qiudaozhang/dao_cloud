package com.qiudaozhang.core.common

import com.qiudaozhang.core.common.consts.StringConst


/**
 * 服务端统一返回格式封装
 */
class R<T> {

    var code: Int = 0
    var message: String = StringConst.EMPTY
    var data: T? = null


    companion object {


        /**
         * 成功处理
         */
        fun <T> suc(data: T): R<T> {
            val r = R<T>()
            r.message = StringConst.SUC
            r.data = data
            return r
        }

        /**
         * 失败处理
         */
        fun <T> fail(code: Int, message: String): R<T> {
            val r = R<T>()
            r.code = code
            r.message = message
            return r
        }
    }
}

