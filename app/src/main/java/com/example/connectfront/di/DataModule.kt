package com.example.connectfront.di

import com.example.data.datasource.LoginDataSource
import com.example.data.datasource.MyPageDataSource
import com.example.data.datasource.SignUpDataSource
import com.example.data.network.LoginApi
import com.example.data.network.MyPageApi
import com.example.data.network.SignUpApi
import com.example.data.repository.LoginRepositoryImpl
import com.example.data.repository.MyPageRepositoryImpl
import com.example.data.repository.SignUpRepositoryImpl
import com.example.domain.repository.LoginRepository
import com.example.domain.repository.MyPageRepository
import com.example.domain.repository.SignUpRepository
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
  fun bindLoginNetwork(loginDataSource: LoginDataSource): LoginApi

  @Binds
  @Singleton
  fun bindSignUpRepository(signUpRepositoryImpl: SignUpRepositoryImpl): SignUpRepository

  @Binds
  @Singleton
  fun bindSignUpNetwork(signUpDataSource: SignUpDataSource): SignUpApi

  @Binds
  @Singleton
  fun bindMyPageRepository(myPageRepositoryImpl: MyPageRepositoryImpl): MyPageRepository

  @Binds
  @Singleton
  fun bindMyPageNetwork(myPageDataSource: MyPageDataSource): MyPageApi
}