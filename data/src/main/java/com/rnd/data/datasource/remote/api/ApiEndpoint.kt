package com.rnd.data.datasource.remote.api

import com.rnd.data.datasource.remote.model.RemoteSearchDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoint {

    @GET("/find")
    fun search(
        @Query("q") q: String
    ): Call<RemoteSearchDataResponse>
}
