package com.example.madecapstoneproject.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.GameUseCase

class HomeGameViewModel(gameUseCase: GameUseCase) : ViewModel() {
    val games = gameUseCase.getAllGames().asLiveData()
}