package com.anant.myportfolio.data.resume

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Education(
    @SerializedName("area")
    val area: String?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("gpa")
    val gpa: String?,
    @SerializedName("institution")
    val institution: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("studyType")
    val studyType: String?
): Parcelable