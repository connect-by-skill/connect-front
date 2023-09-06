package com.example.presentation.model.careerMiddleType

enum class TravelAccommodationEntertainmentServices : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  };

  companion object {
    fun fromString(string: String): TravelAccommodationEntertainmentServices? =
      TravelAccommodationEntertainmentServices.values().find { it.toString() == string }
  }

  override fun toString(): String = when (this) {
    ETC -> "해당 없음"
  }
}
