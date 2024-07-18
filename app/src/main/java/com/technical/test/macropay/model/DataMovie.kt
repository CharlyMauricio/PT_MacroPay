package com.technical.test.macropay.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataMovie (
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Long>,
    val id: Long,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long,
): Parcelable