package com.example.core.utils

import com.example.core.data.source.local.entity.GameEntity
import com.example.core.data.source.remote.response.GameResponse
import com.example.core.domain.model.Game

object DataMapper {

    fun mapResponseToEntities(input: List<GameResponse>): List<GameEntity> {
        val gameList = ArrayList<GameEntity>()

        input.map {
            val genresResponse = it.genres
            val tagsResponse = it.tags
            var stringGenres = ""
            var stringTags = ""
            genresResponse.map {
                stringGenres += "${it.name }, "
            }
            tagsResponse.map {
                stringTags += "${it.name }, "
            }

            val game = GameEntity(
                id = it.id,
                name = it.name,
                background_image = it.background_image,
                released = it.released,
                rating = it.rating,
                ratings_count = it.ratings_count,
                reviews_count = it.reviews_count,
                genres = stringGenres,
                tags = stringTags,
                isFavorite = false,
            )
            gameList.add(game)
        }

        return gameList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>) : List<Game> =
        input.map {
            Game(
                id = it.id,
                name = it.name,
                background_image = it.background_image,
                released = it.released,
                rating = it.rating,
                ratings_count = it.ratings_count,
                reviews_count = it.reviews_count,
                genres = it.genres,
                tags = it.tags,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) = GameEntity(
        id = input.id,
        name = input.name,
        background_image = input.background_image,
        released = input.released,
        rating = input.rating,
        ratings_count = input.ratings_count,
        reviews_count = input.reviews_count,
        genres = input.genres,
        tags = input.tags,
        isFavorite = input.isFavorite
    )


}