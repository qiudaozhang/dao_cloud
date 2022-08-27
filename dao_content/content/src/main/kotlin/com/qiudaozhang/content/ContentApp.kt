package com.qiudaozhang.content

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
open class ContentApp {
}

fun main(array: Array<String>) {
    runApplication<ContentApp>(*array)
}