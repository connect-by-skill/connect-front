package com.example.domain.usecase

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.model.RecommendItemData
import com.example.domain.repository.RecommendRepository
import javax.inject.Inject

class RecommendUseCase @Inject constructor(private val recommendRepository: RecommendRepository){
    fun getRecommendList() : List<RecommendItemData> {
        return recommendRepository.getRecommendList()
    }
    suspend fun getWishListBaseRecommend(id: String) : EntityWrapper<List<CompanyModel>> {
        return recommendRepository.getWishListBaseRecommend(id)
    }
}