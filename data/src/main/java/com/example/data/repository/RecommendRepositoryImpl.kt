package com.example.data.repository

import com.example.data.mapper.CompanyMapper
import com.example.data.mapper.RecommendMapper
import com.example.data.mapper.WishRecommendMapper
import com.example.data.network.RecommendApi
import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.model.RecommendItemData
import com.example.domain.repository.RecommendRepository
import javax.inject.Inject

class RecommendRepositoryImpl @Inject constructor(
  private val recommendApi: RecommendApi,
  private val recommendMapper: RecommendMapper,
  private val wishRecommendMapper: WishRecommendMapper,
) : RecommendRepository {
  override suspend fun getRecommendList(id: String): EntityWrapper<List<RecommendItemData>> {
    return recommendMapper.mapFromResult(
      result = recommendApi.getRecommendList(id)
    )
  }

  override suspend fun getWishListBaseRecommend(id: String): EntityWrapper<List<RecommendItemData>> {
    return wishRecommendMapper.mapFromResult(
      result = recommendApi.getWishListBasedRecommendList(id)
    )
  }

}