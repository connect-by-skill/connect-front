package com.example.domain.repository

import com.example.domain.EntityWrapper
import com.example.domain.model.LoginToken

interface LoginRepository {
    suspend fun login(id: String, pw: String) : EntityWrapper<LoginToken>
}