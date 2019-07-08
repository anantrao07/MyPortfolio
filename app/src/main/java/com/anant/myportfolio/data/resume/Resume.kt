package com.anant.myportfolio.data.resume


import com.google.gson.annotations.SerializedName

data class Resume(
    @SerializedName("awards")
    val awards: ArrayList<Award?>?,
    @SerializedName("basics")
    val basics: Basics?,
    @SerializedName("education")
    val education: ArrayList<Education?>?,
    @SerializedName("headings")
    val headings: Headings?,
    @SerializedName("projects")
    val projects: ArrayList<Project?>?,
    @SerializedName("sections")
    val sections: ArrayList<String?>?,
    @SerializedName("selectedTemplate")
    val selectedTemplate: Int?,
    @SerializedName("skills")
    val skills: ArrayList<Skill?>?,
    @SerializedName("work")
    val work: ArrayList<Work?>?
)