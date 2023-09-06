package com.example.presentation.model.careerMiddleType

enum class SocialWelfareReligiousWork : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  CAREER_COUNSELOR {
    override fun toString(): String = "직업상담사"
  },
  SOCIAL_WORKER {
    override fun toString(): String = "사회복지사(사회복지시설)"
  },
  HOME_CARE_AIDE {
    override fun toString(): String = "재가 요양보호사"
  },
  OTHER_SOCIAL_WELFARE_WORKERS {
    override fun toString(): String = "그 외 사회복지 종사원"
  };

  companion object {
    fun fromString(string: String): SocialWelfareReligiousWork? =
      SocialWelfareReligiousWork.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
