package com.anant.myportfolio.data.resume


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Skill(
    @SerializedName("keywords")
    val keywords: List<String?>?,
    @SerializedName("level")
    val level: String?,
    @SerializedName("name")
    val name: String?
): Parcelable