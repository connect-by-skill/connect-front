package com.example.domain.model.state

import com.example.domain.model.ResumeModel

sealed class MyPageState {
  object Loading: MyPageState()
  class Main(
    var resumeModel: ResumeModel
  ) : MyPageState()
  class Failed(
    val reason: String
  ): MyPageState()
}
