package com.d121211010.NBA.data.source.remote

import com.d121211010.NBA.data.response.GetNbaResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/teams")
    suspend fun getNba(): GetNbaResponse
}