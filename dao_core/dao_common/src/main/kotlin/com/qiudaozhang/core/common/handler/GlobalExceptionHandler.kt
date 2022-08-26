package com.qiudaozhang.core.common.handler

import com.qiudaozhang.core.common.R
import com.qiudaozhang.core.common.exceptions.BizExp
import com.qiudaozhang.core.common.exceptions.CustomException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


/**
 * @author qiudaozhang
 * @since 2022-8-26
 *
 * 全局异常捕获处理
 */
@RestControllerAdvice
class GlobalExceptionHandler: ResponseEntityExceptionHandler() {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    fun bizExp(e: BizExp): R<*> {
        return R.fail<String>(e.code, e.message!!)
    }




    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    fun commonException(e: Exception): R<*> {
        return R.fail<String>(9999, "公共异常")
    }


}