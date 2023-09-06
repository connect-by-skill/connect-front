package com.example.data.datasource

import com.example.data.library.model.ApiResult
import com.example.data.library.model.NetworkRequestInfo
import com.example.data.library.model.RecommendRequest
import com.example.data.library.retrofit.NetworkRecommendFactory
import com.example.data.model.CompanyResponse
import com.google.gson.reflect.TypeToken
import com.example.data.network.RecommendApi
import com.example.domain.model.RecommendItemData
import javax.inject.Inject

class RecommendDataSource @Inject constructor(
    private val networkRecommendFactory: NetworkRecommendFactory
) : RecommendApi {
    val recommendItems = listOf(
        RecommendItemData(1, "금오컴퍼니", "사무직", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),82.6),
        RecommendItemData(2,"대광스카이", "영업직", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),78.8),
        RecommendItemData(3, "삼성 전자", "기술팀", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),76.2),
        RecommendItemData(4,"LG CNS", "PM", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),74.4),
        RecommendItemData(5,"금오사이", "프론트엔드", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),72.6),
        RecommendItemData(6,"대한항공", "마케팅", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),70.3),
        RecommendItemData(7,"금오 건설", "현장 지휘", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),68.7),
        RecommendItemData(8,"금오 전자", "기술 연구", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),66.9),
        RecommendItemData(9,"알바몬", "인사직", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),64.1),
        RecommendItemData(10,"당근마켓", "백엔드", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),62.7)
    )
    fun getRecommendList() : List<RecommendItemData> {
        return recommendItems
    }

    override suspend fun getWishListBasedRecommendList(id: String): ApiResult<List<CompanyResponse>> {
        return networkRecommendFactory.create(
            url = "reco/wish",
            type = object : TypeToken<List<CompanyResponse>>(){}.type,
            requestInfo = NetworkRequestInfo.Builder().withBody(RecommendRequest(id)).build()
        )
    }
}