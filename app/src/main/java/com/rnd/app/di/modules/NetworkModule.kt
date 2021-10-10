package com.rnd.app.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.rnd.app.BuildConfig
import com.rnd.app.BuildConfig.BASE_URL
import com.rnd.app.common.base.HeaderInterceptor
import com.rnd.data.datasource.remote.api.ApiEndpoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val LOG_LEVEL = HttpLoggingInterceptor.Level.BODY

val networkModule = module {

    factory {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(makeGson()))
            .client(get())
            .build()
    }

    factory<OkHttpClient> {
        val httpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            addLoggingInterceptor(httpClient, LOG_LEVEL)
        }
        httpClient.addInterceptor(get<HeaderInterceptor>())
        httpClient.build()
    }

    single<ApiEndpoint> {
        get<Retrofit>().create(
            ApiEndpoint::class.java
        )
    }
}

private fun addLoggingInterceptor(
    httpClient: OkHttpClient.Builder,
    logLevel: HttpLoggingInterceptor.Level
) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = logLevel
    httpClient.addInterceptor(loggingInterceptor)
}

fun makeGson(
): Gson {
    return GsonBuilder().create()
}