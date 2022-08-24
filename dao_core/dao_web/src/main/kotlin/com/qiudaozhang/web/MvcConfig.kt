package com.qiudaozhang.web

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


/**
 * web mvc 基础配置
 */
@Configuration
open class MvcConfig : WebMvcConfigurer {


    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        super.extendMessageConverters(converters)

        for (converter in converters) {
            if (converter is MappingJackson2HttpMessageConverter) {
                val mapper = converter.objectMapper
                val module = SimpleModule()
                mapper.registerModule(module)
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL) // null字段不显示
                converter.objectMapper = mapper
                break
            }
        }
    }


}