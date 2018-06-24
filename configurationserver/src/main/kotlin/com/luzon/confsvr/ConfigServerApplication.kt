package com.luzon.confsvr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

/**
 * Created by heeven on 2018/06/24.
 */
@SpringBootApplication
@EnableConfigServer  // enables the service as a Spring Cloud Config service
class ConfigServerApplication {
}

fun main(args: Array<String>) {
    runApplication<ConfigServerApplication>(*args)
}