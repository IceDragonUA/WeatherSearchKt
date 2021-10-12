package com.rnd.domain.core


/**
 * Default error model that comes from server if something goes wrong with a repository call
 */
data class ErrorModel(val message: String?, val code: Int?) {
    constructor() : this(null, null)
}