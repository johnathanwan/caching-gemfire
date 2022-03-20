package org.example.cachinggemfire

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Suppress("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(val id: Long? = null, val quote: String? = null)
