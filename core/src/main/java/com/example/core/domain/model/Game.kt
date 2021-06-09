package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: String,
    val name: String,
    val background_image: String,
    val released: String,
    val rating: String,
    val ratings_count: String,
    val reviews_count: String,
    val genres: String,
    val tags: String,
    val isFavorite: Boolean
) : Parcelable
