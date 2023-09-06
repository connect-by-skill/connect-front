package com.example.data.mapper

import com.example.data.model.LoginResponse
import com.example.domain.EntityWrapper
import com.example.domain.model.LoginToken
import javax.inject.Inject

class LoginMapper @Inject constructor(

) : BaseMapper<LoginResponse, LoginToken>() {

    override fun getSuccess(model: LoginResponse?, extra: Any?): EntityWrapper.Success<LoginToken> {
        return model?.let {
            EntityWrapper.Success(
                LoginToken(
                    model.atk,
                    model.rtk
                )
            )
        } ?: EntityWrapper.Success(
            LoginToken()
        )
    }


    override fun getFailure(error: Throwable): EntityWrapper.Fail<LoginToken> {
        return EntityWrapper.Fail(error)
    }
}