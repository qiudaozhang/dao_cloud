package com.qiudaozhang.web

import com.qiudaozhang.web.model.SwaggerProperties
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.annotation.Bean
import org.springframework.util.ReflectionUtils
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.Contact
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider
import java.util.stream.Collectors

abstract class BaseSwagger {

    @Bean
    open fun restApi(): Docket {
        val swaggerProperties: SwaggerProperties? = swaggerProperties()
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage(swaggerProperties!!.apiBasePackage))
            .paths(PathSelectors.any())
            .build()
    }

    private fun apiInfo(): ApiInfo {
        val swaggerProperties = swaggerProperties()
        return ApiInfoBuilder()
            .title(swaggerProperties.title)
            .description(swaggerProperties.description)
            .contact(
                Contact(
                    swaggerProperties.contactName,
                    swaggerProperties.contactUrl,
                    swaggerProperties.contactEmail
                )
            )
            .version(swaggerProperties.version)
            .build()
    }

    open fun generateBeanPostProcessor(): BeanPostProcessor? {
        return object : BeanPostProcessor {
            @Throws(BeansException::class)
            override fun postProcessAfterInitialization(bean: Any, beanName: String): Any {
                if (bean is WebMvcRequestHandlerProvider || bean is WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean))
                }
                return bean
            }

            private fun <T : RequestMappingInfoHandlerMapping?> customizeSpringfoxHandlerMappings(mappings: MutableList<T>) {
                val copy = mappings.stream()
                    .filter { mapping: T -> mapping!!.patternParser == null }
                    .collect(Collectors.toList())
                mappings.clear()
                mappings.addAll(copy)
            }

            private fun getHandlerMappings(bean: Any): MutableList<RequestMappingInfoHandlerMapping> {
                return try {
                    val field = ReflectionUtils.findField(bean.javaClass, "handlerMappings")
                    if (field != null) {
                        field.isAccessible = true
                    }
                    field?.get(bean) as MutableList<RequestMappingInfoHandlerMapping>
                } catch (e: IllegalArgumentException) {
                    throw IllegalStateException(e)
                } catch (e: IllegalAccessException) {
                    throw IllegalStateException(e)
                }
            }
        }
    }

    private  fun getContextByPath(pathRegex: String): SecurityContext? {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.regex(pathRegex))
            .build()
    }


    private  fun defaultAuth(): List<SecurityReference>? {
        val result: MutableList<SecurityReference> = ArrayList()
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        result.add(SecurityReference("Authorization", authorizationScopes))
        return result
    }

    abstract fun swaggerProperties(): SwaggerProperties
}