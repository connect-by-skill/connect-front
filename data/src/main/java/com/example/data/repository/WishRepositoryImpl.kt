package com.example.data.repository

import android.util.Log
import com.example.data.mapper.CompanyMapper
import com.example.data.network.WishApi
import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.repository.WishRepository
import javax.inject.Inject

class WishRepositoryImpl @Inject constructor(
    private val wishApi: WishApi,
    private val companyMapper: CompanyMapper
    ) : WishRepository {

    override suspend fun getWishList(): EntityWrapper<List<CompanyModel>> {
        return companyMapper.mapFromResult(
            result = wishApi.getWishList()
        )
    }

    override suspend fun addWishItem(jobAnnouncementId: Int): Int {
        val result = wishApi.addWishItem(jobAnnouncementId)
        return result.code
        }

    override suspend fun deleteWishItem(jobAnnouncementId: Int): Int {
        val result = wishApi.deleteWishItem(jobAnnouncementId)
        Log.d("테스트", "result.toString()")
        return result.code
    }
}



