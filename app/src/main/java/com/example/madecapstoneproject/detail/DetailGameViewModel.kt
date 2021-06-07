package com.example.madecapstoneproject.detail

import androidx.lifecycle.ViewModel
import com.example.core.domain.model.Game
import com.example.core.domain.usecase.GameUseCase

class DetailGameViewModel (private val gameUseCase: GameUseCase) : ViewModel() {

    fun setFavoriteGame(game: Game, newStatus: Boolean) =
        gameUseCase.setFavoriteGame(game, newStatus)

}