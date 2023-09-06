package com.example.domain.repository

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel

interface HomeRepository {
    suspend fun getRankItemList() : EntityWrapper<List<CompanyModel>>
    suspend fun getUserInfo() : Int

}