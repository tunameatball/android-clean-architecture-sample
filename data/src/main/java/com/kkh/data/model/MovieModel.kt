package com.kkh.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("actor")
    val actor: String? = null,

    @SerializedName("director")
    val director: String? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("link")
    val link: String? = null,

    @SerializedName("pubDate")
    val pubDate: String? = null,

    @SerializedName("subtitle")
    val subtitle: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("userRating")
    val userRating: String? = null
)