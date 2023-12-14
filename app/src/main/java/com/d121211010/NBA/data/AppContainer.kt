package com.d121211010.NBA.data

import com.d121211010.NBA.data.repository.NbaRepository
import com.d121211010.NBA.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val nbaRepository: NbaRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://www.balldontlie.io/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val nbaRepository: NbaRepository
        get() = NbaRepository(retrofitService)

}