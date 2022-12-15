package com.xamma.pokedexRestKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.spi.DocumentationType

@SpringBootApplication
class PokedexRestKotlinApplication

fun main(args: Array<String>) {
	runApplication<PokedexRestKotlinApplication>(*args)
}

@Configuration
class SwaggerConfig {
	@Bean
	fun api(): Docket {
		return Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.xamma.pokedexRestKotlin"))
			.paths(PathSelectors.any())
			.build()
	}
}
