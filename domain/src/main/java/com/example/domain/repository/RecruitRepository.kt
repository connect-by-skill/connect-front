package com.example.domain.repository

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel

interface RecruitRepository {
  suspend fun addWishList(jobAnnouncementId: Int): Int
  suspend fun deleteWishList(jobAnnouncementId: Int): Int
  suspend fun getRecruitList(
    experienceTagType: String?,
    companyTagType: String?,
    employmentTagType: String?,
    addressTagType: String?,
    keyword: String, page: Int, sort: String,
  ): EntityWrapper<List<CompanyModel>>
}