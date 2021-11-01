package com.rnd.data.common

abstract class DomainToDatabaseEntityMapper<in T, out R> {

    abstract fun map(input: T?): R
}
