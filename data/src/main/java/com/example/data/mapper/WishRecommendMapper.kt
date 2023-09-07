package com.example.data.mapper

import com.example.data.library.model.ApiResult
import com.example.data.model.RecommendResponse
import com.example.data.model.WishRecommendResponse
import com.example.domain.EntityWrapper
import com.example.domain.model.RecommendItemData
import javax.inject.Inject

class WishRecommendMapper @Inject constructor() :
  BaseMapper<List<WishRecommendResponse>, List<RecommendItemData>>() {
  override fun getSuccess(
    model: List<WishRecommendResponse>?,
    extra: Any?
  ): EntityWrapper.Success<List<RecommendItemData>> {
    return model?.let {
      EntityWrapper.Success(entity = it.map { response ->
        RecommendItemData(
          response.id, response.companyName,
          response.recruitmentType, response.recommendReason, response.score, response.isWish
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
    result: ApiResult<List<WishRecommendResponse>>,
    extra: Any?
  ): EntityWrapper<List<RecommendItemData>> = when (result.code) {
    400 -> getSuccess(model = null, extra)
    else -> super.mapFromResult(result, extra)
  }
}