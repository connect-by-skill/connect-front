package com.example.data.mapper

import com.example.data.model.CompanyResponse
import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import javax.inject.Inject

class RecruitMapper @Inject constructor() : BaseMapper<List<CompanyResponse>, List<CompanyModel>>() {
  override fun getSuccess(
    model: List<CompanyResponse>?,
    extra: Any?
  ): EntityWrapper.Success<List<CompanyModel>> {
    return model?.let {
      EntityWrapper.Success(
        entity = mutableListOf<CompanyModel>()
          .apply {
            addAll(model.map { it.toCompanyModel() })
          }
      )
    } ?: EntityWrapper.Success(
      entity = listOf()
    )
  }

  override fun getFailure(error: Throwable): EntityWrapper.Fail<List<CompanyModel>> {
    return EntityWrapper.Fail(error)
  }
}