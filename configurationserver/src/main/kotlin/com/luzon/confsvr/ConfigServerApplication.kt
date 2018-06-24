package com.luzon.confsvr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Created by heeven on 2018/06/24.
 */
@SpringBootApplication
class Application {
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}