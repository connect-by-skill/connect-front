package com.example.presentation.model.careerMiddleType

enum class Education : CareerMiddleType {
  DESIGN_CAD_INSTRUCTOR {
    override fun toString(): String = "디자인·캐드 강사"
  },
  OTHER_TEACHER {
    override fun toString(): String = "기타 교사"
  },
  NURSING_CARE_TOUR_GUIDE_INSTRUCTOR {
    override fun toString(): String = "간호조무사, 간병, 관광안내 강사"
  },
  LEARNING_MATERIAL_EDUCATIONAL_EQUIPMENT_VISITING_INSTRUCTOR {
    override fun toString(): String = "학습지·교육교구 방문 강사"
  },
  TRAINING_INSTITUTION_ENTERPRISE_INSTRUCTOR {
    override fun toString(): String = "교육연수기관 및 기업체내 강사(리더십, 서비스마인드 등)"
  },
  PROGRAMMING_WEB_WEBDESIGN_DB_INSTRUCTOR {
    override fun toString(): String = "프로그래밍·웹·웹디자인·DB 강사"
  },
  COMPUTER_BASIC_INSTRUCTOR {
    override fun toString(): String = "컴퓨터 기초 강사(OA, 워드, 엑셀, 컴퓨터활용능력 등)"
  },
  ETC {
    override fun toString(): String = "해당 없음"
  };

  companion object {
    fun fromString(string: String): Education? =
      Education.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
