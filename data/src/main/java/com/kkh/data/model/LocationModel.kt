package com.kkh.data.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class LocationModel(
    @SerializedName("address")
    @Expose
    val address: String?,
    @SerializedName("category")
    @Expose
    val category: String?,
    @SerializedName("description")
    @Expose
    val description: String?,
    @SerializedName("link")
    @Expose
    val link: String?,
    @SerializedName("mapx")
    @Expose
    val mapx: String?,
    @SerializedName("mapy")
    @Expose
    val mapy: String?,
    @SerializedName("roadAddress")
    @Expose
    val roadAddress: String?,
    @SerializedName("telephone")
    @Expose
    val telephone: String?,
    @SerializedName("title")
    @Expose
    val title: String?
)