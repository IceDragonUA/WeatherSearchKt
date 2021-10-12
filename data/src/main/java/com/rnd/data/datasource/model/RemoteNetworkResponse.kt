package com.rnd.data.datasource.model

import com.google.gson.annotations.SerializedName

class RemoteResponseError(
    @SerializedName("cod")
    val code: Int?,

    @SerializedName("message")
    val message: String?,
)