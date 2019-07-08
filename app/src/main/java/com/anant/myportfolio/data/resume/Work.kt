package com.anant.myportfolio.data.resume


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Work(
    @SerializedName("company")
    val company: String?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("highlights")
    val highlights: ArrayList<String?>?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("position")
    val position: String?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("website")
    val website: String?
): Parcelable