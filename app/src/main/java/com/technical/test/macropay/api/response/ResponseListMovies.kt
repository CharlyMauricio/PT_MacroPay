package com.technical.test.macropay.api.response

import com.google.gson.annotations.SerializedName
import com.technical.test.macropay.api.dto.DataMovieDTO

data class ResponseListMovies(
    val dates: Dates,
    val page: Long,
    val results: List<DataMovieDTO>,
    @SerializedName("total_pages") val totalPages: Long,
    @SerializedName("total_results") val totalResults: Long,
)

data class Dates(
    val maximum: String,
    val minimum: String,
)
