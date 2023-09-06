package com.example.domain.model.state

import com.example.domain.model.CompanyModel

sealed class RankState {
    object Loading: RankState()
    class Main(
        val rankList: List<CompanyModel>
    ) : RankState()
    class Failed(
        val reason: String
    ): RankState()
}