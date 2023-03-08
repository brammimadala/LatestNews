package com.brahma.latestnews.presentation.di

import com.brahma.latestnews.domain.repository.NewsRepository
import com.brahma.latestnews.domain.usecase.GetNewsHeadLinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsHeadlinesUseCase(newsRepository: NewsRepository): GetNewsHeadLinesUseCase {
        return GetNewsHeadLinesUseCase(newsRepository)
    }
}