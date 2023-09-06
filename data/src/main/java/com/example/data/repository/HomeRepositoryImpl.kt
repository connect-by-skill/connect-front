package com.example.data.repository

import com.example.data.library.model.ApiResponse
import com.example.data.library.model.ApiResult
import com.example.data.mapper.CompanyMapper
import com.example.data.network.HomeApi
import com.example.data.network.UserApi
import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import com.example.domain.model.UserInfo
import com.example.domain.model.UserInfoModel
import com.example.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi,
    private val userApi: UserApi,
    private val companyMapper: CompanyMapper
    ) : HomeRepository {


    override suspend fun getRankItemList() : EntityWrapper<List<CompanyModel>> {
        return companyMapper.mapFromResult(
            result = homeApi.getRankItemList()
        )
    }

    override suspend fun getUserInfo() : Int {
        return userMapping(userApi.getUserInfo())
    }

    fun userMapping(result: ApiResult<UserInfoModel>) : Int {
        return when(result.response) {
            is ApiResponse.Success -> {
                UserInfo.userData = result.response.data
                200
            }
            is ApiResponse.Fail -> {
                400
            }
        }
    }


}