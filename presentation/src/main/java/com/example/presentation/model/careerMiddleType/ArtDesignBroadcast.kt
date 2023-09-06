package com.example.presentation.model.careerMiddleType


enum class ArtDesignBroadcast : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  PAINTER_SCULPTOR {
    override fun toString(): String = "화가 및 조각가"
  },
  CONDUCTOR_COMPOSER_MUSICIAN {
    override fun toString(): String = "지휘자, 작곡가 및 연주가"
  },
  TRAINER_MAGICIAN {
    override fun toString(): String = "조련사(공연)·마술사 등 기타 시각 및 공연 예술가"
  },
  EXTRA_PROP_STAGE {
    override fun toString(): String = "엑스트라, 소품·무대의상 관리 등 기타 연극·영화·방송 종사원"
  };

  companion object {
    fun fromString(string: String): ArtDesignBroadcast? =
      ArtDesignBroadcast.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
