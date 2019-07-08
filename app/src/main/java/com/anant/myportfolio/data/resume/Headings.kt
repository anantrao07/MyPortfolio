package com.anant.myportfolio.data.resume


import com.google.gson.annotations.SerializedName

data class Headings(
    @SerializedName("awards")
    val awards: String?,
    @SerializedName("education")
    val education: String?,
    @SerializedName("projects")
    val projects: String?,
    @SerializedName("skills")
    val skills: String?,
    @SerializedName("work")
    val work: String?,
    val image: String?
)