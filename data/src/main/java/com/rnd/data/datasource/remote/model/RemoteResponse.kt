package com.rnd.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

class RemoteResponseError(
    @SerializedName("result")
    val result: ResponseErrorResult?,
)

class ResponseErrorResult(
    @SerializedName("error")
    val error: ResponseError?
)

class ResponseError(

    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,
)