package com.example.presentation.model.careerMiddleType

enum class InformationCommunicationResearchDevelopmentEngineering : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  INFORMATION_SYSTEM_OPERATOR {
    override fun toString(): String = "정보시스템 운영자"
  },
  WEB_OPERATOR {
    override fun toString(): String = "웹 운영자(홈페이지 관리자)"
  },
  IT_TESTER_QA_SPECIALIST {
    override fun toString(): String = "IT 테스터 및 IT QA 전문가"
  },
  WEB_DESIGNER {
    override fun toString(): String = "웹 디자이너"
  },
  SYSTEM_SOFTWARE_DEVELOPER {
    override fun toString(): String = "시스템 소프트웨어 개발자(프로그래머)"
  },
  WEB_DEVELOPER {
    override fun toString(): String = "웹 개발자(웹 엔지니어·웹 프로그래머)"
  };

  companion object {
    fun fromString(string: String): InformationCommunicationResearchDevelopmentEngineering? =
      InformationCommunicationResearchDevelopmentEngineering.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
