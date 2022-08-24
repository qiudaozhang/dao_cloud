package com.qiudaozhang.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.qiudaozhang.core.common.R
import com.qiudaozhang.core.common.model.DeletedModel
import com.qiudoazhang.db.BaseEntity
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import javax.annotation.Resource


/**
 * 响应增强
 */
@RestControllerAdvice
class ResponseAdvice : ResponseBodyAdvice<Any> {

    @Resource
    lateinit var objectMapper: ObjectMapper

    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return true
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {

        if (body is DeletedModel) {
            // 返回的时候统一隐藏deleted的值 ， 这个只能处理单个值
            body.deleted = null
        }
        if (body is List<*>) {


            // 这个可以处理多个值
            body.forEach { a ->
                run {
                    if (a is DeletedModel) {
                        a.deleted = null
                    }
                }
            }
        }

        return R.suc(body);
    }


}