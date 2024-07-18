package com.technical.test.macropay.api.dto

import com.technical.test.macropay.model.DataMovie

class MovieDTOMapper {

    private fun fromDataMovieDTODTOToDataMovieDTODomain(dataMovieDTO: DataMovieDTO): DataMovie {
        return DataMovie(
            dataMovieDTO.adult,
            dataMovieDTO.backdropPath,
            dataMovieDTO.genreIds,
            dataMovieDTO.id,
            dataMovieDTO.originalLanguage,
            dataMovieDTO.originalTitle,
            dataMovieDTO.overview,
            dataMovieDTO.popularity,
            dataMovieDTO.posterPath,
            dataMovieDTO.releaseDate,
            dataMovieDTO.title,
            dataMovieDTO.video,
            dataMovieDTO.voteAverage,
            dataMovieDTO.voteCount,
        )
    }

    fun fromDataMovieDTODTOListToDataMovieDTODomainList(movieDTOList: List<DataMovieDTO>): List<DataMovie> {
        return movieDTOList.map { fromDataMovieDTODTOToDataMovieDTODomain(it) }
    }
}