package com.rnd.data.common

import com.rnd.domain.core.ErrorModel
import retrofit2.HttpException
import timber.log.Timber

object NetworkErrorMapper {

    fun mapNetworkException(throwable: Throwable?): ErrorModel {
        Timber.e(throwable)
        return when (throwable) {
            is NetworkApiException -> {
                when (val errorCode = throwable.error?.code ?: 0) {
                    401 -> ErrorModel(
                        message = throwable.error?.message,
                        code = errorCode
                    )
                    403 -> ErrorModel(
                        message = throwable.error?.message,
                        code = errorCode
                    )
                    404 -> ErrorModel(
                        message = throwable.error?.message,
                        code = errorCode
                    )
                    422 -> ErrorModel(
                        message = throwable.error?.message,
                        code = errorCode
                    )
                    500 -> ErrorModel(
                        message = throwable.error?.message,
                        code = errorCode
                    )
                    501 -> ErrorModel(
                        message = throwable.error?.message,
                        code = errorCode
                    )
                    in 400 until 600 -> ErrorModel(
                        message = throwable.error?.message,
                        code = errorCode
                    )
                    else -> ErrorModel(
                        message = throwable.error?.message,
                        code = errorCode
                    )
                }
            }

            is HttpException -> {
                when (throwable.code()) {
                    401 -> ErrorModel(
                        throwable.message(),
                        throwable.code()
                    )
                    403 -> ErrorModel(
                        throwable.message(),
                        throwable.code()
                    )
                    404 -> ErrorModel(
                        throwable.message(),
                        throwable.code()
                    )
                    422 -> ErrorModel(
                        throwable.message(),
                        throwable.code()
                    )
                    500 -> ErrorModel(
                        throwable.message(),
                        throwable.code()
                    )
                    501 -> ErrorModel(
                        throwable.message(),
                        throwable.code()
                    )
                    in 400 until 600 -> ErrorModel(
                        throwable.message(),
                        throwable.code()
                    )
                    else -> ErrorModel(
                        throwable.message(),
                        throwable.code()
                    )
                }
            }

            else -> ErrorModel()
        }
    }
}