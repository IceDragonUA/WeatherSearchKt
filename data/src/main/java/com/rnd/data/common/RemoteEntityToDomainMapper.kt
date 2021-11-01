package com.rnd.data.common

abstract class RemoteEntityToDomainMapper<in T, out R> {

    abstract fun map(input: T?): R
}
