package com.example.data.mapper

import com.example.data.model.CompanyResponse
import com.example.domain.model.CompanyModel
import com.example.domain.model.RankItem
import java.text.SimpleDateFormat
import java.util.Calendar

fun CompanyResponse.toRankItem(): RankItem = RankItem(
    company = this.companyName,
    occupation = this.recruitmentType
)

fun CompanyResponse.toCompanyModel(): CompanyModel = CompanyModel(
    id = id,
    applicationDate = applicationDate,
    recruitmentPeriod = recruitmentPeriod,
    companyName = companyName,
    recruitmentType = recruitmentType,
    typeOfEmployment = typeOfEmployment,
    formOfWages = formOfWages,
    wage = wage,
    entryForm = entryForm,
    requiredExperience = requiredExperience,
    requiredEducation = requiredEducation,
    majorField = majorField ?: "",
    requiredCredentials = requiredCredentials ?: "",
    businessAddress = businessAddress,
    companyType = companyType,
    responsibleAgency = responsibleAgency,
    registrationDate = registrationDate,
    contactNumber = contactNumber,
    countOfMemberWish = countOfMemberWish,
    addedWishlist = addedWishlist,
    dDay = getDDay(recruitmentPeriod)
)

private fun getDDay(deadLine: String) : String {

    val dateFormat = SimpleDateFormat("yyyy-MM-dd")

    val endDate = dateFormat.parse(deadLine).time
    val today = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.time.time


    return if(today==endDate) "D-DAY" else if (today>endDate) "D+${(today - endDate) / (24 * 60 * 60 * 1000)}" else "D${(today - endDate) / (24 * 60 * 60 * 1000)}"
}