package com.rnd.data.datasource.remote.api

import com.rnd.data.datasource.model.RemoteSearchResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoint {

    @GET("/find")
    suspend fun search(@Query("q") q: String): Response<RemoteSearchResultResponse>
}
