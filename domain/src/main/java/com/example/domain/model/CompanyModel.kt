package com.example.domain.model

import java.io.Serializable

data class CompanyModel(
    val id: Int,
    val applicationDate: String,
    val recruitmentPeriod: String,
    val companyName: String,
    val recruitmentType: String,
    val typeOfEmployment: String,
    val formOfWages: String,
    val wage: String,
    val entryForm: String,
    val requiredExperience: String,
    val requiredEducation: String,
    val majorField: String = "",
    val requiredCredentials: String ="",
    val businessAddress: String,
    val companyType: String,
    val responsibleAgency: String,
    val registrationDate: String,
    val contactNumber: String,
    val countOfMemberWish: Int,
    var addedWishlist: Boolean = false,
    var dDay: String = ""
): Serializable
