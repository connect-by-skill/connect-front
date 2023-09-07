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
  override suspend fun getRecruitList(
    experienceTagType: String?,
    companyTagType: String?,
    employmentTagType: String?,
    addressTagType: String?,
    keyword: String, page: Int, sort: String,
  ): EntityWrapper<List<CompanyModel>> {
    val result = recruitApi.getRecruitList(
      experienceTagType,
      companyTagType,
      employmentTagType,
      addressTagType,
      keyword,
      page,
      sort
    )
    return recruitMapper.mapFromResult(
      result = result
    )
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