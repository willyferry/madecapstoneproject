package com.example.madecapstoneproject.di

import com.example.core.domain.usecase.GameInteractor
import com.example.core.domain.usecase.GameUseCase
import com.example.madecapstoneproject.detail.DetailGameViewModel
import com.example.madecapstoneproject.home.HomeGameViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeGameViewModel(get()) }
    viewModel { DetailGameViewModel(get()) }
}