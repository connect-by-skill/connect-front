package com.example.presentation.model.careerMiddleType

enum class InformationCommunicationInstallationMaintenance : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  COMMUNICATION_EQUIPMENT_INSTALLATION_AND_REPAIR {
    override fun toString(): String = "통신장비 설치·수리원"
  };
  companion object {
    fun fromString(string: String): InformationCommunicationInstallationMaintenance? =
      InformationCommunicationInstallationMaintenance.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}