package com.rnd.domain.core

sealed class ErrorStatus {
    /**
     * error in connecting to repository (Server or Database)
     */
    object NoConnection : ErrorStatus()

    /**
     * error in getting value (Json Error, Server Error, etc)
     */
    object BadResponse : ErrorStatus()

    object LocationRestriction : ErrorStatus()

    /**
     * Time out  error
     */
    object Timeout : ErrorStatus()

    /**
     * an unexpected error
     */
    object NotDefined : ErrorStatus()

    /**
     * bad credential
     */
    object Unauthorized : ErrorStatus()

    object ValidationFailed : ErrorStatus()
    object NotFound : ErrorStatus()
    object Forbidden : ErrorStatus()

    /**
     * client
     */
    object ServerError : ErrorStatus()
}