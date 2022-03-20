package org.example

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ProviderApplication

fun main(args: Array<String>) {
    runApplication<ProviderApplication>(*args)
}