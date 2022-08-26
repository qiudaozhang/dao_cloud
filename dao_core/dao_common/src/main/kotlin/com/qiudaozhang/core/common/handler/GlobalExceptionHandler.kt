package com.qiudaozhang.core.common.handler

import com.qiudaozhang.core.common.R
import com.qiudaozhang.core.common.exceptions.BizExp
import com.qiudaozhang.core.common.exceptions.CustomException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


/**
 * @author qiudaozhang
 * @since 2022-8-26
 *
 * 全局异常捕获处理
 */
@RestControllerAdvice
class GlobalExceptionHandler {


    // 其它异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomException::class)
    fun cE(e: CustomException): R<*> {

        println("自定义异常")

        return R.fail<String>(9999, "其它异常，请联系开发人员")
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(java.lang.Exception::class)
    fun commonException(e: java.lang.Exception): R<*> {

        println(e::class)
        // kotlin 这里似乎无法从精细到更一般的异常处理，我们这里合并处理，内部区分
        if (e is BizExp) {
            return R.fail<Any>(e.code, e.message!!)
        }
        if (e is CustomException) {
            println("自定义异常")
        }

        return R.fail<String>(9999, "其它异常，请联系开发人员")
    }


}