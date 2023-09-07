package com.example.presentation.model

import java.lang.reflect.Type

enum class TagType {
  NONE {
    override fun getMajorType(): Type = String::class.java
    override fun toString(): String = "무관"
  },
  ENTRY {
    override fun getMajorType(): Type = ExperienceTagType::class.java
    override fun toString(): String = "신입"
  },
  EXPERIENCED {
    override fun getMajorType(): Type = ExperienceTagType::class.java
    override fun toString(): String = "경력"
  },
  LARGE_COMPANY {
    override fun getMajorType(): Type = CompanyTagType::class.java
    override fun toString(): String = "대기업"
  },
  SMALL_MEDIUM_ENTERPRISE {
    override fun getMajorType(): Type = CompanyTagType::class.java
    override fun toString(): String = "중소"
  },
  CONSTRUCTION {
    override fun getMajorType(): Type = CompanyTagType::class.java
    override fun toString(): String = "공사"
  },
  PUBLIC {
    override fun getMajorType(): Type = CompanyTagType::class.java
    override fun toString(): String = "공공"
  },
  ASSOCIATION {
    override fun getMajorType(): Type = CompanyTagType::class.java
    override fun toString(): String = "협회"
  },
  ORGANIZATION {
    override fun getMajorType(): Type = CompanyTagType::class.java
    override fun toString(): String = "단체"
  },
  INDIVIDUAL {
    override fun getMajorType(): Type = CompanyTagType::class.java
    override fun toString(): String = "개인"
  },
  CONTRACT_EMPLOYEE {
    override fun getMajorType(): Type = EmploymentTagType::class.java
    override fun toString(): String = "계약직"
  },
  REGULAR_EMPLOYEE {
    override fun getMajorType(): Type = EmploymentTagType::class.java
    override fun toString(): String = "상용직"
  },
  SEOUL {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "서울"
  },
  GYEONGGI_DO {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "경기도"
  },
  GYEONGSANGBUK_DO {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "경상북도"
  },
  GYEONGSANGNAM_DO {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "경상남도"
  },
  CHUNGCHEONGBUK_DO {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "충청북도"
  },
  CHUNGCHEONGNAM_DO {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "충청남도"
  },
  JEOLLABUK_DO {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "전라북도"
  },
  JEOLLANAM_DO {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "전라남도"
  },
  GANGWON_DO {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "강원도"
  },
  GUMI {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "구미"
  },
  DAEGU {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "대구"
  },
  BUSAN {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "부산"
  },
  INCHEON {
    override fun getMajorType(): Type = AddressTagType::class.java
    override fun toString(): String = "인천"
  };

  companion object {
    fun fromString(string: String): TagType =
      TagType.values().find { it.toString() == string } ?: NONE
  }

  abstract fun getMajorType(): Type
  abstract override fun toString(): String
}

class EmploymentTagType()

class CompanyTagType()

class ExperienceTagType()

class AddressTagType()

