package com.qiudaozhang.web

import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer
import com.qiudaozhang.core.common.consts.TimePool
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Configuration
open class TimeConfig {


    // 注意，无法这种方式无法处理普通 query param 日期
    @Bean
    open fun timeBuilder(): Jackson2ObjectMapperBuilderCustomizer {

        val mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        // T 处理
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        // 忽略时区
        mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
        val serializers: MutableMap<Class<*>, JsonSerializer<*>> = HashMap()

        serializers[LocalDateTime::class.java] =
            LocalDateTimeSerializer(DateTimeFormatter.ofPattern(TimePool.YMD_HMS))
        serializers[LocalDate::class.java] = LocalDateSerializer(DateTimeFormatter.ofPattern(TimePool.YMD))
        serializers[LocalTime::class.java] = LocalTimeSerializer(DateTimeFormatter.ofPattern(TimePool.HMS))

        val deserializers = hashMapOf<Class<*>, JsonDeserializer<*>>(
            LocalDateTime::class.java to LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(TimePool.YMD_HMS)),
            LocalDate::class.java to LocalDateDeserializer(DateTimeFormatter.ofPattern(TimePool.YMD)),
            LocalDateTime::class.java to LocalTimeDeserializer(DateTimeFormatter.ofPattern(TimePool.HMS))
        )
        return Jackson2ObjectMapperBuilderCustomizer { builder: Jackson2ObjectMapperBuilder ->
            builder.serializersByType(serializers).deserializersByType(deserializers).configure(mapper)
        }
    }
}