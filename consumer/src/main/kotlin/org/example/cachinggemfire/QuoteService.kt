package org.example.cachinggemfire

import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

@Suppress("unused")
@Service
class QuoteService {

    companion object {
        internal const val ID_BASED_QUOTE_SERVICE_URL = "http://localhost:8088/{id}"
        internal const val RANDOM_QUOTE_SERVICE_URL = "http://localhost:8088/random"
    }

    @Volatile
    private var cacheMiss = false
    private val quoteServiceTemplate = RestTemplate()

    fun isCacheMiss(): Boolean {
        val cacheMiss = this.cacheMiss
        this.cacheMiss = false
        return cacheMiss
    }

    internal fun setCacheMiss() {
        this.cacheMiss = true
    }

    @Cacheable("Quotes")
    fun requestQuote(id: Long): Quote {
        setCacheMiss()
        return requestQuote(ID_BASED_QUOTE_SERVICE_URL, Collections.singletonMap("id", id))
    }

    @Suppress("SpringElInspection")
    @CachePut(cacheNames = ["Quotes"], key = "#result.id")
    fun requestRandomQuote(): Quote {
        setCacheMiss()
        return requestQuote(RANDOM_QUOTE_SERVICE_URL)
    }

    internal fun requestQuote(URL: String): Quote {
        return requestQuote(URL, Collections.emptyMap())
    }

    internal fun requestQuote(URL: String, urlVariables: Map<String, Any>): Quote {
        return quoteServiceTemplate.getForObject(URL, QuoteResponse::class.java, urlVariables)!!.quote!!
    }

}