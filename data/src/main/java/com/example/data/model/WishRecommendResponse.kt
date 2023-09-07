package com.example.data.model

import com.google.gson.annotations.SerializedName

data class WishRecommendResponse(
  @SerializedName("id") val id: Int,
  @SerializedName("applicationDate") val applicationDate: String,
  @SerializedName("businessAddress") val businessAddress: String,
  @SerializedName("companyName") val companyName: String,
  @SerializedName("companyType") val companyType: String,
  @SerializedName("contactNumber") val contactNumber: String,
  @SerializedName("entryForm") val entryForm: String,
  @SerializedName("formOfWages") val formOfWages: String,
  @SerializedName("majorField") val majorField: String?,
  @SerializedName("recruitmentPeriod") val recruitmentPeriod: String,
  @SerializedName("recruitmentType") val recruitmentType: String,
  @SerializedName("registrationDate") val registrationDate: String,
  @SerializedName("requiredCredentials") val requiredCredentials: String?,
  @SerializedName("requiredEducation") val requiredEducation: String,
  @SerializedName("requiredExperience") val requiredExperience: String,
  @SerializedName("responsibleAgency") val responsibleAgency: String,
  @SerializedName("typeOfEmployment") val typeOfEmployment: String,
  @SerializedName("whyRecommand") val recommendReason: List<String>,
  @SerializedName("wage") val wage: Int,
  val score: Double = 0.0,
  val isWish: Boolean = false
)