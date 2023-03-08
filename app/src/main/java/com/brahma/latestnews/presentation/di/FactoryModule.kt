package com.brahma.latestnews.presentation.di

import android.app.Application
import com.brahma.latestnews.domain.usecase.GetNewsHeadLinesUseCase
import com.brahma.latestnews.presentation.viewModel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadLinesUseCase: GetNewsHeadLinesUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadLinesUseCase)
    }
}