package com.example.data.model

import com.google.gson.annotations.SerializedName

data class CompanyResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("applicationDate")
    val applicationDate: String,
    @SerializedName("recruitmentPeriod")
    val recruitmentPeriod: String,
    @SerializedName("companyName")
    val companyName: String,
    @SerializedName("recruitmentType")
    val recruitmentType: String,
    @SerializedName("typeOfEmployment")
    val typeOfEmployment: String,
    @SerializedName("formOfWages")
    val formOfWages: String,
    @SerializedName("wage")
    val wage: String,
    @SerializedName("entryForm")
    val entryForm: String,
    @SerializedName("requiredExperience")
    val requiredExperience: String,
    @SerializedName("requiredEducation")
    val requiredEducation: String,
    @SerializedName("majorField")
    val majorField: String = "",
    @SerializedName("requiredCredentials")
    val requiredCredentials: String ="",
    @SerializedName("businessAddress")
    val businessAddress: String,
    @SerializedName("companyType")
    val companyType: String,
    @SerializedName("responsibleAgency")
    val responsibleAgency: String,
    @SerializedName("registrationDate")
    val registrationDate: String,
    @SerializedName("contactNumber")
    val contactNumber: String,
    @SerializedName("countOfMemberWish")
    val countOfMemberWish: Int,
    @SerializedName("addedWishlist")
    val addedWishlist: Boolean = false,

)
