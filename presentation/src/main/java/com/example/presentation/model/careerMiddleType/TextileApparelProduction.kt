package com.example.presentation.model.careerMiddleType

enum class TextileApparelProduction : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  FABRIC_INSPECTOR {
    override fun toString(): String = "의복·직물 검사 등 기타 섬유·가죽 기능원"
  },
  TAILOR {
    override fun toString(): String = "양장·양복 제조원"
  },
  TEXTILE_WORKER {
    override fun toString(): String = "섬유·의복 분야 단순 종사원"
  },
  CUTTER {
    override fun toString(): String = "재단사"
  },
  SEAMSTRESS {
    override fun toString(): String = "재봉사(의류·직물)"
  },
  TEXTILE_PROCESSOR {
    override fun toString(): String = "섬유가공 준비 및 후가공 처리원"
  };

  companion object {
    fun fromString(string: String): TextileApparelProduction? =
      TextileApparelProduction.values().find { it.toString() == string }
  }
}