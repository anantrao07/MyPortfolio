package com.anant.myportfolio.data.resume


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("address")
    val address: String?
)