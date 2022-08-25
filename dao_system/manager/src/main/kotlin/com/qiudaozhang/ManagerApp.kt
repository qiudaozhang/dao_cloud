package com.qiudaozhang

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
// 添加扫描，否则不生效
@EnableDiscoveryClient
@EnableDubbo
open class ManagerApp

fun main(array: Array<String>) {
    runApplication<ManagerApp>(*array)
}