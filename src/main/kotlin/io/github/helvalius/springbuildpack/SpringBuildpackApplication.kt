package io.github.helvalius.springbuildpack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBuildpackApplication

fun main(args: Array<String>) {
	runApplication<SpringBuildpackApplication>(*args)
}
