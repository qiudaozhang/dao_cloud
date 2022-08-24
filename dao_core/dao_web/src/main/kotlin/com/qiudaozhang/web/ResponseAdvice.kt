package com.qiudaozhang.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.qiudaozhang.core.common.R
import com.qiudaozhang.core.common.model.DeletedModel
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import springfox.documentation.spring.web.json.Json
import springfox.documentation.swagger.web.SwaggerResource
import javax.annotation.Resource


/**
 * 响应增强，减少控制器的样板代码
 * @author qiudaozhang
 * @since 2022-8-24
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


        // 文档的内容不能代理，否则看不到ui
        if (body is Json) {
            return body
        }

        if (body is List<*>) {
            var hasSwaggerResource = false
            for (c in body) {
                if (c is SwaggerResource) {
                    // 满足一个就退出，提高速度
                    hasSwaggerResource = true
                    break
                }
            }
            if (hasSwaggerResource) {
                return body
            }
        }
//        println(body!!::class.java)
//        println(body)
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
        // 其他类型也可以参照这个的方式进行处理
        return R.suc(body);
    }


}