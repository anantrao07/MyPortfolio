package com.anant.myportfolio.data.resume


import com.google.gson.annotations.SerializedName

data class Award(
    @SerializedName("awarder")
    val awarder: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("title")
    val title: String?
)