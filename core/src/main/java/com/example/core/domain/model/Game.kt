package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    val id: String,
    val name: String,
    val background_image: String,
    val released: String,
    val isFavorite: Boolean
) : Parcelable
