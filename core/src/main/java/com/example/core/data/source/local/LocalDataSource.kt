package com.example.core.data.source.local

import com.example.core.data.source.local.entity.GameEntity
import com.example.core.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gameDao: GameDao){

    fun getAllGames(): Flow<List<GameEntity>> = gameDao.getAllGames()

    fun getFavoriteGames(): Flow<List<GameEntity>> = gameDao.getFavoriteGames()

    suspend fun insertGames(gamesList: List<GameEntity>) = gameDao.insertGames(gamesList)

    fun setFavoriteGame(game: GameEntity, newState: Boolean) {
        game.isFavorite = newState
        gameDao.updateFavoriteGame(game)
    }


}