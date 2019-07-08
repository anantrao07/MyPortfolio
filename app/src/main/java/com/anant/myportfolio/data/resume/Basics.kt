package com.anant.myportfolio.data.resume


import com.google.gson.annotations.SerializedName

data class Basics(
    @SerializedName("email")
    val email: String?,
    @SerializedName("ic_location")
    val location: Location?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone")
    val phone: String?
)