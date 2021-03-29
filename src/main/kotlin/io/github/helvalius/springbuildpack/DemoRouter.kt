package io.github.helvalius.springbuildpack

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RenderingResponse
import org.springframework.web.reactive.function.server.router

@Component
class DemoRouter(private val fooHandler: FooHandler) {
    fun router () = router {
        GET("/foo", fooHandler::foo)
    }
}

