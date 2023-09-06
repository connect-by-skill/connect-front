package com.example.data.mapper

import com.example.data.library.model.ApiResponse
import com.example.data.library.model.ApiResult
import com.example.domain.EntityWrapper

abstract class BaseMapper<M, E> {

    open fun mapFromResult(result: ApiResult<M>, extra: Any? = null): EntityWrapper<E> =
        when (result.response) {
            is ApiResponse.Success -> getSuccess(model = result.response.data, extra = extra)
            is ApiResponse.Fail -> getFailure(error = result.response.error)
        }

    fun getCode(result: ApiResult<M>, extra: Any? = null): EntityWrapper<Int> =
        when (result.response) {
            is ApiResponse.Success -> EntityWrapper.Success(result.code)
            is ApiResponse.Fail -> EntityWrapper.Success(404)
        }

    abstract fun getSuccess(model: M?, extra: Any?): EntityWrapper.Success<E>

    abstract fun getFailure(error: Throwable): EntityWrapper.Fail<E>
}