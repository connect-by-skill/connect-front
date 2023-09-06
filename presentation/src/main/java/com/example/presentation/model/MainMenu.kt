package com.example.presentation.model

import androidx.annotation.DrawableRes
import com.example.presentation.R

sealed class MainMenu(val name: String, @DrawableRes val res: Int) {
    object Home: MainMenu(name = "홈", res = R.drawable.home)
    object Recruit: MainMenu(name = "채용정보", res = R.drawable.domain)
    object Recommend: MainMenu(name = "추천", res = R.drawable.thumb_up)
    object WishList: MainMenu(name = "위시리스트", res = R.drawable.clober)
    object MyPage: MainMenu(name = "마이페이지", res = R.drawable.person)
}