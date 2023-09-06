package com.example.data.library.model

import com.google.gson.annotations.SerializedName

sealed class ApiResponse<out T> {
    class Success<T>(
        @SerializedName("data") val data: T
    ) : ApiResponse<T>()

    class Fail(
        @SerializedName("error") val error: Throwable
    ) : ApiResponse<Nothing>()
}