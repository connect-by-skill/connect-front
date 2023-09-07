package com.example.domain.usecase

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.model.RecommendItemData
import com.example.domain.repository.RecommendRepository
import javax.inject.Inject

class RecommendUseCase @Inject constructor(private val recommendRepository: RecommendRepository){
    suspend fun getRecommendList(id: String) : EntityWrapper<List<RecommendItemData>> {
        return recommendRepository.getRecommendList(id)
    }
    suspend fun getWishListBaseRecommend(id: String) : EntityWrapper<List<RecommendItemData>> {
        return recommendRepository.getWishListBaseRecommend(id)
    }
}