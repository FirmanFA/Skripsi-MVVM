package com.skripsi.mvvm.domain

sealed class Resource<out T> {
    object Pending : Resource<Nothing>()
    data class Success<T>(val data: T? = null) : Resource<T>()
    data class Failure(val e: Throwable) : Resource<Nothing>()
}


