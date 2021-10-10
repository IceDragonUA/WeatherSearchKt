package com.rnd.data.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rnd.data.datasource.remote.model.RemoteResponseError
import com.rnd.domain.core.ErrorModel
import com.rnd.domain.core.Failure
import com.rnd.domain.core.Result
import com.rnd.domain.core.Success
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

fun <T, R> Call<T>.safeExecute(mapper: DataMapper<T, R>): Result<R, ErrorModel> {
    return try {
        val execute = execute()
        val data = execute.map { mapper.map(it) }
        Success(data, execute.code())
    } catch (e: Exception) {
        Failure(NetworkErrorMapper.mapNetworkException(e))
    }
}

inline fun <T, R> Response<T>.map(transform: (T) -> R): R {
    val body = body()
    val error = errorBody()?.let {
        errorMapper(it)
    }
    body ?: throw NetworkApiException(error)
    return body.let(transform)
}

fun errorMapper(errorBody: ResponseBody): RemoteResponseError? {
    val type = object : TypeToken<RemoteResponseError>() {}.type
    return Gson().fromJson(errorBody.charStream(), type)
}
