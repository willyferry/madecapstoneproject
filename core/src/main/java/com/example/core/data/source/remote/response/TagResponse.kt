package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TagResponse(
    @field:SerializedName("name")
    val name: String
)