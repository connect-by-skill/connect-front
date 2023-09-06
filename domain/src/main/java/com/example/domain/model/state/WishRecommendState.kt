package com.example.domain.model.state

import com.example.domain.model.CompanyModel

sealed class WishRecommendState {
    object Loading: WishRecommendState()
    class Main(
        val companyList : List<CompanyModel>
    ) : WishRecommendState()
    class Failed(
        val reason : String
    ) : WishRecommendState()
}