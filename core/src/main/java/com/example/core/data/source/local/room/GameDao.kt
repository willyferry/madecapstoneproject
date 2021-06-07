package com.example.core.data.source.local.room

import androidx.room.*
import com.example.core.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM games")
    fun getAllGames(): Flow<List<GameEntity>>

    @Query("SELECT * FROM games where isFavorite = 1")
    fun getFavoriteGames(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(gamesEntity: List<GameEntity>)

    @Update
    fun updateFavoriteGame(game: GameEntity)

}