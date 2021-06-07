package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.GameUseCase

class FavoriteGameViewModel (gameUseCase: GameUseCase) : ViewModel() {
    val favoriteGames = gameUseCase.getFavoriteGames().asLiveData()
}