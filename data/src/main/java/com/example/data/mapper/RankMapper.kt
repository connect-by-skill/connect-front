package com.example.data.mapper

import com.example.data.model.CompanyResponse
import com.example.domain.EntityWrapper
import com.example.domain.model.RankItem
import javax.inject.Inject

class RankMapper @Inject constructor(

) : BaseMapper<List<CompanyResponse>, List<RankItem>>() {
    override fun getSuccess(
        model: List<CompanyResponse>?,
        extra: Any?
    ): EntityWrapper.Success<List<RankItem>> {
        return model?.let {
            EntityWrapper.Success(
                entity = mutableListOf<RankItem>()
                    .apply {
                        addAll(model.map { it.toRankItem() })
                    }
            )
        } ?: EntityWrapper.Success(
            entity = listOf()
        )
    }

    override fun getFailure(error: Throwable): EntityWrapper.Fail<List<RankItem>> {
        return EntityWrapper.Fail(error)
    }
}