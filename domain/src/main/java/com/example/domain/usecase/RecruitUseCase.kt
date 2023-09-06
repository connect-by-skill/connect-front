package com.example.domain.usecase

import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.repository.RecruitRepository
import javax.inject.Inject

class RecruitUseCase @Inject constructor(private val recruitRepository: RecruitRepository) {
  suspend fun getRecruitList(page:Int, sort: String): EntityWrapper<List<CompanyModel>> {
    return this.recruitRepository.getRecruitList(page, sort)
  }

  suspend fun changeIsWished(companyId: Int, isWished: Boolean) {
    if(!isWished) recruitRepository.addWishList(companyId)
    else recruitRepository.deleteWishList(companyId)
  }
}