package com.rnd.domain.core


/**
 * Default error model that comes from server if something goes wrong with a repository call
 */
data class ErrorModel(
    val message: String?,
    val code: Int?,
    @Transient var errorStatus: ErrorStatus? = null
) {
    constructor(errorStatus: ErrorStatus) : this(null, null, errorStatus)
    constructor(code: Int?, errorStatus: ErrorStatus) : this(null, code, errorStatus)
}