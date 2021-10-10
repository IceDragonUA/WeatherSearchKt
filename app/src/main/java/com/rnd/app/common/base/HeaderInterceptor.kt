package com.rnd.app.common.base

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.koin.core.KoinComponent
import java.io.IOException

class HeaderInterceptor : Interceptor, KoinComponent {

    companion object {
        const val KEY_HEADER_NAME = "x-rapidapi-key"
        const val KEY_HEADER_TOKEN = "ab39c14032msh9da95f3cdafe504p11281fjsn9facfc120337"
        const val HOST_HEADER_NAME = "x-rapidapi-host"
        const val HOST_HEADER_TOKEN = "community-open-weather-map.p.rapidapi.com"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = getRequestWithAccessToken(chain)
        try {
            return chain.proceed(request)
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getRequestWithAccessToken(
        chain: Interceptor.Chain
    ): Request {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .header("Accept", "application/json")
            .header(KEY_HEADER_NAME, KEY_HEADER_TOKEN)
            .header(HOST_HEADER_NAME, HOST_HEADER_TOKEN)
            .method(original.method(), original.body())
        return requestBuilder.build()
    }
}
