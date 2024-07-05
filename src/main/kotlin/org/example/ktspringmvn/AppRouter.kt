package org.example.ktspringmvn

import org.example.ktspringmvn.handler.AppHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class AppRouter {

    @Bean
    fun route(handler: AppHandler): RouterFunction<ServerResponse> = router {
        GET("/", handler::index)
        GET("/health") {
            ServerResponse.ok().bodyValue("Spring server is up and running 🚀🚀")
        }
    }
}