package com.rnd.data.common

abstract class DatabaseEntityToFromDomainMapper<T, R> {

    abstract fun mapTo(input: T?): R
    abstract fun mapFrom(input: R?): T
}
