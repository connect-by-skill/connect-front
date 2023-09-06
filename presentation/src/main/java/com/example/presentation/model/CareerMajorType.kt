package com.example.presentation.model

import com.example.presentation.model.careerMiddleType.AgricultureForestryFishery
import com.example.presentation.model.careerMiddleType.ArtDesignBroadcast
import com.example.presentation.model.careerMiddleType.BeautyWeddingService
import com.example.presentation.model.careerMiddleType.BusinessAdministrationClerical
import com.example.presentation.model.careerMiddleType.CareServiceCaregivingChildcare
import com.example.presentation.model.careerMiddleType.CareerMiddleType
import com.example.presentation.model.careerMiddleType.ChemicalEnvironmentalInstallationMaintenanceProduction
import com.example.presentation.model.careerMiddleType.CleaningAndOtherPersonalServices
import com.example.presentation.model.careerMiddleType.ConstructionMining
import com.example.presentation.model.careerMiddleType.ConstructionMiningResearchDevelopmentEngineering
import com.example.presentation.model.careerMiddleType.DrivingTransportation
import com.example.presentation.model.careerMiddleType.Education
import com.example.presentation.model.careerMiddleType.ElectricalElectronicInstallationMaintenanceProduction
import com.example.presentation.model.careerMiddleType.FinanceInsurance
import kgb.plum.presentation.model.careerMiddleType.FoodProcessingProduction
import com.example.presentation.model.careerMiddleType.FoodService
import com.example.presentation.model.careerMiddleType.HealthcareMedicalServices
import com.example.presentation.model.careerMiddleType.HumanitiesSocialSciencesResearch
import com.example.presentation.model.careerMiddleType.InformationCommunicationInstallationMaintenance
import com.example.presentation.model.careerMiddleType.InformationCommunicationResearchDevelopmentEngineering
import com.example.presentation.model.careerMiddleType.Legal
import com.example.presentation.model.careerMiddleType.ManagementExecutiveDepartmentHead
import com.example.presentation.model.careerMiddleType.ManufacturingResearchDevelopmentEngineering
import com.example.presentation.model.careerMiddleType.ManufacturingUnskilled
import com.example.presentation.model.careerMiddleType.MechanicalInstallationMaintenanceProduction
import com.example.presentation.model.careerMiddleType.MetalMaterialInstallationMaintenanceProduction
import com.example.presentation.model.careerMiddleType.NaturalLifeScienceResearch
import com.example.presentation.model.careerMiddleType.PrintingWoodCraftAndOtherInstallationMaintenanceProduction
import com.example.presentation.model.careerMiddleType.SalesAndRetail
import com.example.presentation.model.careerMiddleType.SecurityGuard
import com.example.presentation.model.careerMiddleType.SocialWelfareReligiousWork
import com.example.presentation.model.careerMiddleType.SportsRecreation
import com.example.presentation.model.careerMiddleType.TextileApparelProduction
import com.example.presentation.model.careerMiddleType.TravelAccommodationEntertainmentServices

enum class CareerMajorType {
  BUSINESS_ADMINISTRATION_CLERICAL {
    override fun toString(): String = "경영 행정 사무직"
    override fun getMiddleType(): List<CareerMiddleType> = BusinessAdministrationClerical.values().toList()
  },
  DRIVING_TRANSPORTATION {
    override fun toString(): String = "운전 운송직"
    override fun getMiddleType(): List<CareerMiddleType> = DrivingTransportation.values().toList()
  },
  MECHANICAL_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "기계 설치정비 생산직"
    override fun getMiddleType(): List<CareerMiddleType> = MechanicalInstallationMaintenanceProduction.values().toList()
  },
  METAL_MATERIAL_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "금속 재료 설치 정비 생산직"
    override fun getMiddleType(): List<CareerMiddleType> = MetalMaterialInstallationMaintenanceProduction.values().toList()
  },
  CHEMICAL_ENVIRONMENTAL_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "화학 환경 설치 정비 생산직"
    override fun getMiddleType(): List<CareerMiddleType> = ChemicalEnvironmentalInstallationMaintenanceProduction.values().toList()
  },
  ELECTRICAL_ELECTRONIC_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "전기 전자 설치 정비 생산직"
    override fun getMiddleType(): List<CareerMiddleType> = ElectricalElectronicInstallationMaintenanceProduction.values().toList()
  },
  MANUFACTURING_RESEARCH_DEVELOPMENT_ENGINEERING {
    override fun getMiddleType(): List<CareerMiddleType> = ManufacturingResearchDevelopmentEngineering.values().toList()
    override fun toString(): String = "제조 연구개발직 및 공학기술직"
  },
  TEXTILE_APPAREL_PRODUCTION {
    override fun toString(): String = "섬유 의복 생산직"
    override fun getMiddleType(): List<CareerMiddleType> = TextileApparelProduction.values().toList()
  },
  MANUFACTURING_UNSKILLED {
    override fun toString(): String = "제조 단순직"
    override fun getMiddleType(): List<CareerMiddleType> = ManufacturingUnskilled.values().toList()
  },
  INFORMATION_COMMUNICATION_INSTALLATION_MAINTENANCE {
    override fun toString(): String = "정보통신 설치 정비직"
    override fun getMiddleType(): List<CareerMiddleType> = InformationCommunicationInstallationMaintenance.values().toList()
  },
  PRINTING_WOOD_CRAFT_AND_OTHER_INSTALLATION_MAINTENANCE_PRODUCTION {
    override fun toString(): String = "인쇄 목재 공예 및 기타 설치 정비 생산직"
    override fun getMiddleType(): List<CareerMiddleType> = PrintingWoodCraftAndOtherInstallationMaintenanceProduction.values().toList()
  },
  FOOD_PROCESSING_PRODUCTION {
    override fun toString(): String = "식품 가공 생산직"
    override fun getMiddleType(): List<CareerMiddleType> = FoodProcessingProduction.values().toList()
  },
  EDUCATION {
    override fun toString(): String = "교육직"
    override fun getMiddleType(): List<CareerMiddleType> = Education.values().toList()
  },
  FINANCE_INSURANCE {
    override fun toString(): String = "금융 보험직"
    override fun getMiddleType(): List<CareerMiddleType> = FinanceInsurance.values().toList()
  },
  ART_DESIGN_BROADCASTING {
    override fun toString(): String = "예술 디자인 방송직"
    override fun getMiddleType(): List<CareerMiddleType> = ArtDesignBroadcast.values().toList()
  },
  FOOD_SERVICE {
    override fun toString(): String = "음식 서비스직"
    override fun getMiddleType(): List<CareerMiddleType> = FoodService.values().toList()
  },
  CLEANING_AND_OTHER_PERSONAL_SERVICES {
    override fun toString(): String = "청소 및 기타 개인서비스직"
    override fun getMiddleType(): List<CareerMiddleType> = CleaningAndOtherPersonalServices.values().toList()
  },
  HEALTH_MEDICAL {
    override fun toString(): String = "보건 의료직"
    override fun getMiddleType(): List<CareerMiddleType> = HealthcareMedicalServices.values().toList()
  },
  SOCIAL_WELFARE_RELIGION {
    override fun toString(): String = "사회복지 종교직"
    override fun getMiddleType(): List<CareerMiddleType> = SocialWelfareReligiousWork.values().toList()
  },
  CARE_SERVICE_CAREGIVING_CHILDCARE {
    override fun toString(): String = "돌봄 서비스직 간병 육아"
    override fun getMiddleType(): List<CareerMiddleType> = CareServiceCaregivingChildcare.values().toList()
  },
  MANAGEMENT_EXECUTIVE_DEPARTMENT_HEAD {
    override fun toString(): String = "관리직 임원 부서장"
    override fun getMiddleType(): List<CareerMiddleType> = ManagementExecutiveDepartmentHead.values().toList()
  },
  SECURITY_GUARD {
    override fun toString(): String = "경호 경비직"
    override fun getMiddleType(): List<CareerMiddleType> = SecurityGuard.values().toList()
  },
  SALES {
    override fun toString(): String = "영업 판매직"
    override fun getMiddleType(): List<CareerMiddleType> = SalesAndRetail.values().toList()
  },
  AGRICULTURE_FORESTRY_FISHERY {
    override fun toString(): String = "농림어업직"
    override fun getMiddleType(): List<CareerMiddleType> = AgricultureForestryFishery.values().toList()
  },
  INFORMATION_COMMUNICATION_RESEARCH_DEVELOPMENT_ENGINEERING_TECHNICAL {
    override fun toString(): String = "정보통신 연구개발직 및 공학기술직"
    override fun getMiddleType(): List<CareerMiddleType> = InformationCommunicationResearchDevelopmentEngineering.values().toList()
  },
  SPORTS_RECREATION {
    override fun toString(): String = "스포츠 레크리에이션직"
    override fun getMiddleType(): List<CareerMiddleType> = SportsRecreation.values().toList()
  },
  BEAUTY_WEDDING_SERVICE {
    override fun toString(): String = "미용 예식 서비스직"
    override fun getMiddleType(): List<CareerMiddleType> = BeautyWeddingService.values().toList()
  },
  NATURAL_LIFE_SCIENCE_RESEARCH {
    override fun toString(): String = "자연 생명과학 연구직"
    override fun getMiddleType(): List<CareerMiddleType> = NaturalLifeScienceResearch.values().toList()
  },
  CONSTRUCTION_MINING_RESEARCH_DEVELOPMENT_ENGINEERING_TECHNICAL {
    override fun toString(): String = "건설 채굴 연구개발직 및 공학기술직"
    override fun getMiddleType(): List<CareerMiddleType> = ConstructionMiningResearchDevelopmentEngineering.values().toList()
  },
  CONSTRUCTION_MINING {
    override fun toString(): String = "건설 채굴직"
    override fun getMiddleType(): List<CareerMiddleType> = ConstructionMining.values().toList()
  },
  LEGAL {
    override fun toString(): String = "법률직"
    override fun getMiddleType(): List<CareerMiddleType> = Legal.values().toList()
  },
  HUMANITIES_SOCIAL_SCIENCE_RESEARCH {
    override fun toString(): String = "인문 사회과학 연구직"
    override fun getMiddleType(): List<CareerMiddleType> = HumanitiesSocialSciencesResearch.values().toList()
  },
  TRAVEL_ACCOMMODATION_ENTERTAINMENT_SERVICE {
    override fun toString(): String = "여행 숙박 오락 서비스직"
    override fun getMiddleType(): List<CareerMiddleType> = TravelAccommodationEntertainmentServices.values().toList()
  };

  companion object {
    fun fromString(string: String): CareerMajorType? =
      CareerMajorType.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
  abstract fun getMiddleType(): List<CareerMiddleType>
}