package com.example.presentation.model

enum class TagType {
  NONE {
    override fun toString(): String = "무관"
  },
  ENTRY {
    override fun toString(): String = "신입"
  },
  EXPERIENCED {
    override fun toString(): String = "경력"
  },
  SALARY {
    override fun toString(): String = "연봉"
  },
  LARGE_COMPANY {
    override fun toString(): String = "대기업"
  },
  SMALL_MEDIUM_ENTERPRISE {
    override fun toString(): String = "중소"
  },
  CONSTRUCTION {
    override fun toString(): String = "공사"
  },
  PUBLIC {
    override fun toString(): String = "공공"
  },
  ASSOCIATION {
    override fun toString(): String = "협회"
  },
  ORGANIZATION {
    override fun toString(): String = "단체"
  },
  INDIVIDUAL {
    override fun toString(): String = "개인"
  },
  FOREIGN_COMPANY {
    override fun toString(): String = "외국계"
  },
  CONTRACT_EMPLOYEE {
    override fun toString(): String = "계약직"
  },
  REGULAR_EMPLOYEE {
    override fun toString(): String = "상용직"
  },
  SAFE_WORKPLACE {
    override fun toString(): String = "안전사업장"
  },
  BARRIER_FREE {
    override fun toString(): String = "배리어프리"
  },
  HEALTH_CENTER {
    override fun toString(): String = "건강센터"
  },
  SEOUL {
    override fun toString(): String = "서울"
  },
  GYEONGGI_DO {
    override fun toString(): String = "경기도"
  },
  GYEONGSANGBUK_DO {
    override fun toString(): String = "경상북도"
  },
  GYEONGSANGNAM_DO {
    override fun toString(): String = "경상남도"
  },
  CHUNGCHEONGBUK_DO {
    override fun toString(): String = "충청북도"
  },
  CHUNGCHEONGNAM_DO {
    override fun toString(): String = "충청남도"
  },
  JEOLLABUK_DO {
    override fun toString(): String = "전라북도"
  },
  JEOLLANAM_DO {
    override fun toString(): String = "전라남도"
  },
  GANGWON_DO {
    override fun toString(): String = "강원도"
  },
  GUMI {
    override fun toString(): String = "구미"
  },
  DAEGU {
    override fun toString(): String = "대구"
  },
  BUSAN {
    override fun toString(): String = "부산"
  },
  INCHEON {
    override fun toString(): String = "인천"
  };

  companion object {
    fun fromString(string: String): TagType =
      TagType.values().find { it.toString() == string } ?: NONE
  }

  abstract override fun toString(): String
}