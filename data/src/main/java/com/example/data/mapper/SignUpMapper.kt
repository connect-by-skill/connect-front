package com.example.data.mapper

import com.example.data.model.SignUpRequest
import com.example.domain.EntityWrapper
import javax.inject.Inject

class SignUpMapper @Inject constructor(

) : BaseMapper<SignUpRequest, Int>() {

    override fun getSuccess(model: SignUpRequest?, extra: Any?): EntityWrapper.Success<Int> {
        return model?.let {
            EntityWrapper.Success(0)
        } ?: EntityWrapper.Success(entity = 0)
    }


    override fun getFailure(error: Throwable): EntityWrapper.Fail<Int> {
        return EntityWrapper.Fail(error)
    }
}