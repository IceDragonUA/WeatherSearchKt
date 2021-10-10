package com.rnd.data.common

import com.rnd.domain.core.ErrorModel
import com.rnd.domain.core.ErrorStatus
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object NetworkErrorMapper {

    fun mapNetworkException(throwable: Throwable?): ErrorModel {
        Timber.e(throwable)
        return when (throwable) {
            is NetworkApiException -> {
                when (val errorCode = throwable.error?.result?.error?.code ?: 0) {
                    401 -> ErrorModel(
                        message = throwable.error?.result?.error?.message,
                        code = errorCode,
                        errorStatus = ErrorStatus.Unauthorized
                    )
                    403 -> ErrorModel(
                        message = throwable.error?.result?.error?.message,
                        code = errorCode,
                        errorStatus = ErrorStatus.Forbidden
                    )
                    404 -> ErrorModel(
                        message = throwable.error?.result?.error?.message,
                        code = errorCode,
                        errorStatus = ErrorStatus.NotFound
                    )
                    422 -> ErrorModel(
                        message = throwable.error?.result?.error?.message,
                        code = errorCode,
                        errorStatus = ErrorStatus.ValidationFailed
                    )
                    500 -> ErrorModel(
                        message = throwable.error?.result?.error?.message,
                        code = errorCode,
                        errorStatus = ErrorStatus.ServerError
                    )
                    501 -> ErrorModel(
                        message = throwable.error?.result?.error?.message,
                        code = errorCode,
                        errorStatus = ErrorStatus.LocationRestriction
                    )
                    in 400 until 600 -> ErrorModel(
                        message = throwable.error?.result?.error?.message,
                        code = errorCode,
                        errorStatus = ErrorStatus.BadResponse
                    )
                    else -> ErrorModel(
                        message = throwable.error?.result?.error?.message,
                        code = errorCode,
                        errorStatus = ErrorStatus.NotDefined
                    )
                }
            }

            is HttpException -> {
                when (throwable.code()) {
                    401 -> ErrorModel(
                        throwable.message(),
                        throwable.code(),
                        ErrorStatus.Unauthorized
                    )
                    403 -> ErrorModel(
                        throwable.message(),
                        throwable.code(),
                        ErrorStatus.Forbidden
                    )
                    404 -> ErrorModel(
                        throwable.message(),
                        throwable.code(),
                        ErrorStatus.NoConnection
                    )
                    422 -> ErrorModel(
                        throwable.message(),
                        throwable.code(),
                        ErrorStatus.ValidationFailed
                    )
                    500 -> ErrorModel(
                        throwable.message(),
                        throwable.code(),
                        ErrorStatus.ServerError
                    )
                    501 -> ErrorModel(
                        throwable.message(),
                        throwable.code(),
                        ErrorStatus.LocationRestriction
                    )
                    in 400 until 600 -> ErrorModel(
                        throwable.message(),
                        throwable.code(),
                        ErrorStatus.BadResponse
                    )
                    else -> ErrorModel(
                        throwable.message(),
                        throwable.code(),
                        ErrorStatus.NotDefined
                    )
                }
            }

            // handle api call timeout error
            is SocketTimeoutException -> {
                ErrorModel(errorStatus = ErrorStatus.Timeout)
            }

            is UnknownHostException -> {
                ErrorModel(errorStatus = ErrorStatus.NoConnection)
            }

            // handle connection error
            is IOException -> {
                ErrorModel(errorStatus = ErrorStatus.NoConnection)
            }
            else -> ErrorModel(errorStatus = ErrorStatus.NotDefined)
        }
    }
}