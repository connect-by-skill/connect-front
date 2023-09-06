package com.example.domain.usecase

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.repository.WishRepository
import javax.inject.Inject

class WishUseCase @Inject constructor(private val wishRepository: WishRepository) {

    suspend fun getWishList(): EntityWrapper<List<CompanyModel>> {
        return wishRepository.getWishList()
    }

    suspend fun addWishItem(jobAnnouncementId: Int): Int {
        return wishRepository.addWishItem(jobAnnouncementId)
    }

    suspend fun deleteWishItem(jobAnnouncementId: Int): Int {
        return wishRepository.deleteWishItem(jobAnnouncementId)
    }
}