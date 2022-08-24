package com.qiudaozhang.config

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j
import com.qiudaozhang.core.common.consts.ProjectConst
import com.qiudaozhang.web.BaseSwagger
import com.qiudaozhang.web.model.SwaggerProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@EnableKnife4j
open class SwaggerConfig : BaseSwagger() {

    override fun swaggerProperties(): SwaggerProperties {
        val p = SwaggerProperties()
        p.apiBasePackage = "com.qiudaozhang.controller"
        p.title = "账号服务"
        p.description = "账户服务接口文档"
        p.contactName = ProjectConst.MAINTAINER
        p.version = ProjectConst.VERSION
        return p
    }

    @Bean
    open fun springfoxHandlerProviderBeanPostProcessor(): BeanPostProcessor? {
        return generateBeanPostProcessor()
    }
}