package com.d121211010.NBA.data.repository

import com.d121211010.NBA.data.response.GetNbaResponse
import com.d121211010.NBA.data.source.remote.ApiService

class NbaRepository(private val apiService: ApiService){

    suspend fun getNba(): GetNbaResponse {
        return apiService.getNba()
    }
}