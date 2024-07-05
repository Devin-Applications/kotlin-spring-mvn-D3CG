package org.example.ktspringmvn.handler

import org.example.ktspringmvn.dto.Message
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class AppHandler {

    fun index(request: ServerRequest): Mono<ServerResponse> = ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(Message("Hello Spring !"))
}