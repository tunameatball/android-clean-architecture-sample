package com.kkh.data.model


import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("display")
    val display: Int?,
    @SerializedName("items")
    val items: List<LocationModel>?,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String?,
    @SerializedName("start")
    val start: Int?,
    @SerializedName("total")
    val total: Int?
)