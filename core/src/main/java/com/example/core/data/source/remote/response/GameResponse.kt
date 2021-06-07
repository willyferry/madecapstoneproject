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

)