package org.example.cachinggemfire

import org.apache.geode.cache.client.*
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions

@SpringBootApplication
@ClientCacheApplication(name = "CachingGemFireApplication")
@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireCaching
class CachingGemfireApplication {

    @Bean
    fun runner(quoteService: QuoteService): ApplicationRunner {
        return ApplicationRunner {
            val quote = requestQuote(quoteService, 12L)
            requestQuote(quoteService, quote.id)
            requestQuote(quoteService, 10L)
        }
    }

    internal fun requestQuote(quoteService: QuoteService, id: Long?): Quote {

        val startTime = System.currentTimeMillis()

        val quote = if (id != null) quoteService.requestQuote(id) else quoteService.requestRandomQuote()
        val elapsedTime = System.currentTimeMillis()

        println("$quote \nCache miss [${quoteService.isCacheMiss()}] - Elapsed Time [${elapsedTime - startTime}]")
        return quote
    }
}

fun main(args: Array<String>) {
    runApplication<CachingGemfireApplication>(*args)
}
