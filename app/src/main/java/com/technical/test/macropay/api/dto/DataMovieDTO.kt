package com.technical.test.macropay.api.dto

import com.squareup.moshi.Json

data class DataMovieDTO (
    val adult: Boolean,
    @field:Json(name = "backdrop_path") val backdropPath: String,
    @field:Json(name = "genre_ids") val genreIds: List<Long>,
    val id: Long,
    @field:Json(name = "original_language") val originalLanguage: String,
    @field:Json(name = "original_title") val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @field:Json(name = "poster_path") val posterPath: String,
    @field:Json(name = "release_date") val releaseDate: String,
    val title: String,
    val video: Boolean,
    @field:Json(name = "vote_average") val voteAverage: Double,
    @field:Json(name = "vote_count") val voteCount: Long,
)