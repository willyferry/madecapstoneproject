package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse (

    @field:SerializedName("id")
    var id: String,

    @field:SerializedName("name")
    var name: String,

    @field:SerializedName("background_image")
    var background_image: String,

    @field:SerializedName("released")
    var released: String,

    @field:SerializedName("rating")
    var rating: String,

    @field:SerializedName("ratings_count")
    var ratings_count: String,

    @field:SerializedName("reviews_count")
    var reviews_count: String,

    @field:SerializedName("genres")
    var genres: List<GenreResponse>,

    @field:SerializedName("tags")
    var tags: List<TagResponse>

)