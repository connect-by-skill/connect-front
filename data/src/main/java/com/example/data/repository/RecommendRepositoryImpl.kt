package com.example.data.repository

import com.example.data.datasource.RecommendDataSource
import com.example.data.mapper.CompanyMapper
import com.example.data.network.RecommendApi
import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.model.RecommendItemData
import com.example.domain.repository.RecommendRepository
import javax.inject.Inject

class RecommendRepositoryImpl @Inject constructor(
    private val recommendDataSource: RecommendDataSource,
    private val recommendApi: RecommendApi,
    private val companyMapper: CompanyMapper
    ) : RecommendRepository {
    override fun getRecommendList(): List<RecommendItemData> {
        return recommendDataSource.getRecommendList()
    }

    override suspend fun getWishListBaseRecommend(id: String): EntityWrapper<List<CompanyModel>> {
        return companyMapper.mapFromResult(
            result = recommendApi.getWishListBasedRecommendList(id)
        )
    }

}