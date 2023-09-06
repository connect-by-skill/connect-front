package com.example.data.repository

import com.example.data.mapper.RecruitMapper
import com.example.data.network.RecruitApi
import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.repository.RecruitRepository
import javax.inject.Inject

class RecruitRepositoryImpl @Inject constructor(
  private val recruitApi: RecruitApi,
  private val recruitMapper: RecruitMapper
) : RecruitRepository {
  override suspend fun getRecruitList(page: Int, sort: String): EntityWrapper<List<CompanyModel>> {
    return recruitMapper.mapFromResult(result = recruitApi.getRecruitList(page, sort))
  }

  override suspend fun addWishList(jobAnnouncementId: Int): Int {
    val result = recruitApi.addWishList(jobAnnouncementId)
    return result.code
  }

  override suspend fun deleteWishList(jobAnnouncementId: Int): Int {
    val result = recruitApi.deleteWishList(jobAnnouncementId)
    return result.code
  }
}