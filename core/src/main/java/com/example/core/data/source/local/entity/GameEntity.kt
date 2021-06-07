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

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)