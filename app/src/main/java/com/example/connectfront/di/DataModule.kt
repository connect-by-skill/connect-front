package com.example.connectfront.di

import com.example.data.datasource.LoginDataSource
import com.example.data.network.LoginApi
import com.example.data.repository.LoginRepositoryImpl
import com.example.domain.repository.LoginRepository
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
}