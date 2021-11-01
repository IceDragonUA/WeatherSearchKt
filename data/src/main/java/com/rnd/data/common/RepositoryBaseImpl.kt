package com.rnd.data.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rnd.data.datasource.model.RemoteResponseError
import com.rnd.domain.core.ErrorModel
import com.rnd.domain.core.ResultModel
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * @author Vladyslav Havrylenko
 * @since 01.11.2021
 */
open class RepositoryBaseImpl {

    suspend fun <T, R> getResponse(
        request: suspend () -> Response<T>,
        mapper: RemoteEntityToDomainMapper<T, R>,
        defaultErrorMessage: String = "Unknown error"
    ): ResultModel<R> {
        return try {
            val result = request.invoke()
            return if (result.isSuccessful) {
                ResultModel.success(mapper.map(result.body()))
            } else {
                val error = result.errorBody()?.let {
                    errorMapper(it)
                }
                ResultModel.error(error?.message ?: defaultErrorMessage, ErrorModel(message = error?.message, code = error?.code))
            }
        } catch (e: Throwable) {
            ResultModel.error(defaultErrorMessage, ErrorModel())
        }
    }

    private fun errorMapper(errorBody: ResponseBody): RemoteResponseError? {
        val type = object : TypeToken<RemoteResponseError>() {}.type
        return Gson().fromJson(errorBody.charStream(), type)
    }
}