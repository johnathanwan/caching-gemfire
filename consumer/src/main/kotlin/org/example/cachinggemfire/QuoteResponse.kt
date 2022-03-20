package org.example.cachinggemfire

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.example.cachinggemfire.*

@Suppress("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
class QuoteResponse(
    @field:JsonProperty("value") val quote: Quote? = null,
    @field:JsonProperty("type") val status: String? = null,
)