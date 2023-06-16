package com.kkh.data.mapper

import com.kkh.data.model.LocationModel
import com.kkh.data.model.MovieModel
import com.kkh.domain.model.Location
import com.kkh.domain.model.Movie

fun MovieModel.toMovie(): Movie {
    return Movie(
        actor, director, image, link, pubDate, subtitle, title, userRating
    )
}

fun LocationModel.toLocation(): Location {
    return Location(
        address, category, description, link, mapx, mapy, roadAddress, telephone, title
    )
}