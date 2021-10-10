package com.rnd.domain.core

sealed class Result<Payload, Error>
data class Success<Payload, Error>(val payload: Payload, val code:Int = 0) : Result<Payload, Error>()
data class Failure<Payload, Error>(val error: Error) : Result<Payload, Error>()