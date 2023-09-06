package com.example.domain.usecase

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository){


    suspend fun getRankItemList() : EntityWrapper<List<CompanyModel>> {
        return homeRepository.getRankItemList()
    }

    suspend fun  getUserInfo() : Int {
        return homeRepository.getUserInfo()
    }
}