package com.example.connectfront.di

import com.example.data.datasource.HomeDataSource
import com.example.data.datasource.LoginDataSource
import com.example.data.datasource.MyPageDataSource
import com.example.data.datasource.RecommendDataSource
import com.example.data.datasource.RecruitDataSource
import com.example.data.datasource.SignUpDataSource
import com.example.data.datasource.UserDataSource
import com.example.data.datasource.WishDataSource
import com.example.data.network.HomeApi
import com.example.data.network.LoginApi
import com.example.data.network.MyPageApi
import com.example.data.network.RecommendApi
import com.example.data.network.RecruitApi
import com.example.data.network.SignUpApi
import com.example.data.network.UserApi
import com.example.data.network.WishApi
import com.example.data.repository.HomeRepositoryImpl
import com.example.data.repository.LoginRepositoryImpl
import com.example.data.repository.MyPageRepositoryImpl
import com.example.data.repository.RecommendRepositoryImpl
import com.example.data.repository.RecruitRepositoryImpl
import com.example.data.repository.SignUpRepositoryImpl
import com.example.data.repository.WishRepositoryImpl
import com.example.domain.repository.HomeRepository
import com.example.domain.repository.LoginRepository
import com.example.domain.repository.MyPageRepository
import com.example.domain.repository.RecommendRepository
import com.example.domain.repository.RecruitRepository
import com.example.domain.repository.SignUpRepository
import com.example.domain.repository.WishRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
  @Binds
  @Singleton
  fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

  @Binds
  @Singleton
  fun bindSignUpRepository(signUpRepositoryImpl: SignUpRepositoryImpl): SignUpRepository

  @Binds
  @Singleton
  fun bindRecruitRepository(recruitRepositoryImpl: RecruitRepositoryImpl): RecruitRepository

  @Binds
  @Singleton
  fun bindMyPageRepository(myPageRepositoryImpl: MyPageRepositoryImpl): MyPageRepository

  @Binds
  @Singleton
  fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

  @Binds
  @Singleton
  fun bindRecommendRepository(recommendRepositoryImpl: RecommendRepositoryImpl): RecommendRepository

  @Binds
  @Singleton
  fun bindWishRepository(wishRepositoryImpl: WishRepositoryImpl): WishRepository

  @Binds
  @Singleton
  fun bindHomeNetwork(homeDataSource: HomeDataSource): HomeApi

  @Binds
  @Singleton
  fun bindSignUpNetwork(signUpDataSource: SignUpDataSource): SignUpApi

  @Binds
  @Singleton
  fun bindLoginNetwork(loginDataSource: LoginDataSource): LoginApi

  @Binds
  @Singleton
  fun bindUserNetwork(userDataSource: UserDataSource): UserApi

  @Binds
  @Singleton
  fun bindWishNetwork(wishDataSource: WishDataSource): WishApi

  @Binds
  @Singleton
  fun bindMyPageNetwork(myPageDataSource: MyPageDataSource): MyPageApi

  @Binds
  @Singleton
  fun bindRecommendNetwork(recommendDataSource: RecommendDataSource) : RecommendApi

  @Binds
  @Singleton
  fun bindRecruitNetwork(recruitDataSource: RecruitDataSource) : RecruitApi
}