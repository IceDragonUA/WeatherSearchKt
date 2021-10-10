package com.rnd.data.common

interface DataMapper<in T, out R> {

    fun map(input: T): R

}