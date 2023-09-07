package com.example.data.mapper

import com.example.data.library.model.ApiResult
import com.example.data.model.RecommendResponse
import com.example.domain.EntityWrapper
import com.example.domain.model.RecommendItemData
import javax.inject.Inject

class RecommendMapper @Inject constructor() :
  BaseMapper<List<RecommendResponse>, List<RecommendItemData>>() {
  override fun getSuccess(
    model: List<RecommendResponse>?,
    extra: Any?
  ): EntityWrapper.Success<List<RecommendItemData>> {
    return model?.let {
      EntityWrapper.Success(entity = it.map { response ->
        RecommendItemData(
          response.id, response.company,
          response.jobCategoryMiddle, response.recommendReason, response.score, response.isWish
        )
      })
    } ?: EntityWrapper.Success(
      entity = listOf()
    )
  }

  override fun getFailure(error: Throwable): EntityWrapper.Fail<List<RecommendItemData>> {
    return EntityWrapper.Fail(error)
  }

  override fun mapFromResult(
    result: ApiResult<List<RecommendResponse>>,
    extra: Any?
  ): EntityWrapper<List<RecommendItemData>> = when (result.code) {
    400 -> getSuccess(model = null, extra)
    else -> super.mapFromResult(result, extra)
  }
}