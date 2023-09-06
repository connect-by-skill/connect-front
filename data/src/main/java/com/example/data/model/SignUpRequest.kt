package com.example.data.model

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("encryptedPwd")
    val encryptedPwd: String,
    @SerializedName("addressInfo")
    val addressInfo: String,
    @SerializedName("addressDetails")
    val addressDetails: String,
    @SerializedName("disabilityType")
    val disabilityType: String
)
