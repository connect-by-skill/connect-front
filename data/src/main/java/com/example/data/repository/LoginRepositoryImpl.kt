package com.example.data.repository

import com.example.data.mapper.LoginMapper
import com.example.data.network.LoginApi
import com.example.domain.EntityWrapper
import com.example.domain.model.LoginToken
import com.example.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi,
    private val loginMapper: LoginMapper
) : LoginRepository {
    override suspend fun login(id: String, pw: String): EntityWrapper<LoginToken> {
        val result = loginApi.login(email = id, password = pw)
        val mappingData = loginMapper.mapFromResult(result)
        if( mappingData is EntityWrapper.Success){
            mappingData.entity.code = result.code
        }
        return mappingData
    }

}