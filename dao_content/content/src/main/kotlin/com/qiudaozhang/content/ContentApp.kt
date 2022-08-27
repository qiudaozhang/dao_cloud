package com.qiudaozhang.content

import com.qiudaozhang.content.mapper.ArticleMapper
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
@MapperScan(basePackageClasses = [ArticleMapper::class])
open class ContentApp {
}

fun main(array: Array<String>) {
    runApplication<ContentApp>(*array)
}