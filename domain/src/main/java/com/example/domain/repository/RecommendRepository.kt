package com.example.domain.repository

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.model.RecommendItemData

interface RecommendRepository {
    suspend fun getRecommendList(id: String): EntityWrapper<List<RecommendItemData>>

    suspend fun getWishListBaseRecommend(id: String) : EntityWrapper<List<RecommendItemData>>
}