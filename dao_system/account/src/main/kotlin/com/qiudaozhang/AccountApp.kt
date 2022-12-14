package com.qiudaozhang

import com.qiudaozhang.mapper.AccountMapper
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@SpringBootApplication
@MapperScan(basePackageClasses = [AccountMapper::class])
@EnableDiscoveryClient
@EnableDubbo
open class AccountApp

fun main(array: Array<String>) {
    runApplication<AccountApp>(*array)
}