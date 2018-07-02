package com.luzon.servicegateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

/**
 * Created by heeven on 2018/07/01.
 */
@SpringBootApplication
@EnableZuulProxy
class ServiceGatewayApplication {
}

fun main(args: Array<String>) {
    runApplication<ServiceGatewayApplication>(*args)
}
