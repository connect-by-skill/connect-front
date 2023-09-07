package com.example.data.model

import com.google.gson.annotations.SerializedName

data class RecommendResponse(
  val id: Int,
  val applicationDate: String,
  val recruitmentPeriod: String,
  @SerializedName("companyName") val company: String,
  @SerializedName("recruitmentType") val recruitmentType: String,
  val typeOfEmployment: String,
  val formOfWages: String,
  val wage: Int,
  val entryForm: String,
  val requiredExperience: String,
  val requiredEducation: String,
  val majorField: String,
  val requiredCredentials: String,
  val businessAddress: String,
  val companyType: String,
  val responsibleAgency: String,
  val registrationDate: String,
  val contactNumber: String,
  val jobCategoryBig: String,
  val jobCategoryMiddle: String,
  @SerializedName("bariaFree") val barrierFree: Int,
  @SerializedName("safeComapny") val safeCompany: Int,
  @SerializedName("whyRecommand") val recommendReason: List<String>,
  @SerializedName("value") val score: Double,
  val isWish: Boolean = false
)