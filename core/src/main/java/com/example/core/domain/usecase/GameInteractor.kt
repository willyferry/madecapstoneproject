package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.Game
import com.example.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow

class GameInteractor(private val gameRepository: IGameRepository): GameUseCase {
    override fun getAllGames(): Flow<Resource<List<Game>>> = gameRepository.getAllGames()

    override fun getFavoriteGames(): Flow<List<Game>> = gameRepository.getFavoriteGames()

    override fun setFavoriteGame(game: Game, state: Boolean) = gameRepository.setFavoriteGame(game, state)
}