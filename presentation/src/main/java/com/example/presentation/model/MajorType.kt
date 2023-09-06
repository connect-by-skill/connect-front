package com.example.presentation.model

enum class MajorType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  ELECTRONIC_ENGINEERING {
    override fun toString(): String = "전자공학"
  },
  ELECTRICAL_ENGINEERING {
    override fun toString(): String = "전기공학"
  },
  LIBRARY_AND_INFORMATION_SCIENCE {
    override fun toString(): String = "문헌정보학"
  },
  PUBLIC_HEALTH {
    override fun toString(): String = "보건학"
  },
  BIOLOGY {
    override fun toString(): String = "생물학"
  },
  FAMILY_SOCIAL_WELFARE {
    override fun toString(): String = "가족·사회·복지학"
  },
  CIVIL_ENGINEERING {
    override fun toString(): String = "토목공학"
  },
  LAW {
    override fun toString(): String = "법학"
  },
  ARCHITECTURE {
    override fun toString(): String = "건축학"
  };

  companion object {
    fun fromString(string: String): MajorType? =
      MajorType.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}