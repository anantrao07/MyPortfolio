package com.anant.myportfolio.data.resume


import com.google.gson.annotations.SerializedName

data class Project(
    @SerializedName("description")
    val description: String?,
    @SerializedName("keywords")
    val keywords: List<String?>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)