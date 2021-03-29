package io.github.helvalius.springbuildpack

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class FooHandler {
        fun foo(serverRequest: ServerRequest?): Mono<ServerResponse> {
            return ServerResponse
                    .ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(BodyInserters.fromValue(RESPONSE_TEXT))
        }

        companion object {
            protected var RESPONSE_TEXT = "Hello Reactive Cloud Native Buildpack Builders :)!"
        }
}
