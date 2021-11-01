package com.rnd.domain.core

data class ResultModel<out T>(val status: Status, val data: T?, val error: ErrorModel?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): ResultModel<T> {
            return ResultModel(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, error: ErrorModel): ResultModel<T> {
            return ResultModel(Status.ERROR, null, error, message)
        }

        fun <T> loading(data: T? = null): ResultModel<T> {
            return ResultModel(Status.LOADING, data, null, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}