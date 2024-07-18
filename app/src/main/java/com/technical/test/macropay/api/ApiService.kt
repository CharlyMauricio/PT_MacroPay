package com.technical.test.macropay.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

object Api {
    val retrofitService: Endpoints by lazy {
        retrofit.create(Endpoints::class.java)
    }
}