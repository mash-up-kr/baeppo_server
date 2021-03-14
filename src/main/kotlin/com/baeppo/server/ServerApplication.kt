package com.baeppo.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class ServerApplication : SpringBootServletInitializer() {

    companion object {
        const val APPLICATION_LOCATIONS = "spring.config.location="
                .plus("classpath:/application.properties,")
                .plus("classpath:/aws.yml")

    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application
                .sources(ServerApplication::class.java)
                .properties(APPLICATION_LOCATIONS)
    }
}


fun main(args: Array<String>) {
    SpringApplication.run(ServerApplication::class.java, *args)
}
