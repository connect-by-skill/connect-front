package com.example.domain.model.state

import com.example.domain.model.CompanyModel

sealed class RecruitState {
  object Loading: RecruitState()
  class Main(
    val recruitList: List<CompanyModel>
  ) : RecruitState()
  class Failed(
    val reason: String
  ): RecruitState()
}