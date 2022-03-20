package org.example

import org.springframework.web.bind.annotation.*

@Suppress("unused")
@RestController
class Controller {
    @GetMapping("/{id}")
    fun byId(@PathVariable(value = "id") id: Long): Quote {
        val value1 = Value(10, "Really loving Spring Boot, makes stand alone Spring apps easy.")
        val value2 = Value(12, "Working with Spring Boot is like pair-programming with the Spring developers.")
        val valueId = Value(id, "Working with Spring Boot is like pair-programming with the Spring developers.")

        val value = when (id) {
            10L -> value1
            12L -> value2
            else -> valueId
        }
        return Quote("success",value)
    }
}