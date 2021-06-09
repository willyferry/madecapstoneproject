package com.example.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "background_image")
    var background_image: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "ratings_count")
    var ratings_count: String,

    @ColumnInfo(name = "reviews_count")
    var reviews_count: String,

    @ColumnInfo(name = "genres")
    var genres: String,

    @ColumnInfo(name = "tags")
    var tags: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)