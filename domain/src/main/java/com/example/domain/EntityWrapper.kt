package com.example.domain

sealed class EntityWrapper<T> {
    data class Success<T>(val entity: T) : EntityWrapper<T>()
    data class Fail<T>(val error: Throwable) : EntityWrapper<T>()
}