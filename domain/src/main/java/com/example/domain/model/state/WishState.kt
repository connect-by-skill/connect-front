package com.example.domain.model.state

import com.example.domain.model.CompanyModel

sealed class WishState {
    object Loading: WishState()
    class Main(
        val wishList: MutableList<CompanyModel>
    ) : WishState()
    class Failed(
        val reason: String
    ): WishState()
}