package com.example.domain.repository

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel

interface WishRepository {
    suspend fun getWishList() : EntityWrapper<List<CompanyModel>>
    suspend fun addWishItem(jobAnnouncementId: Int) : Int
    suspend fun deleteWishItem(jobAnnouncementId: Int) : Int
}