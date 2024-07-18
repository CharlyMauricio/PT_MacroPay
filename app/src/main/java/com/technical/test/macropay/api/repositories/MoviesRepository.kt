package com.technical.test.macropay.api.repositories

import com.technical.test.macropay.api.Api.retrofitService
import com.technical.test.macropay.api.TOKEN
import com.technical.test.macropay.api.dto.MovieDTOMapper
import com.technical.test.macropay.model.DataMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository {

    suspend fun downloadMovies(): List<DataMovie> {
        return withContext(Dispatchers.IO) {
            val moviesResponse = retrofitService.getListMovies(1, TOKEN)
            val movieDTOList = moviesResponse.results
            val movieDTOMapper = MovieDTOMapper()
            movieDTOMapper.fromDataMovieDTODTOListToDataMovieDTODomainList(movieDTOList)
        }
    }


}