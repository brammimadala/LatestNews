package com.brahma.latestnews.presentation.di

import com.brahma.latestnews.data.repository.NewsRepositoryImpl
import com.brahma.latestnews.data.repository.dataSource.NewsRemoteDataSource
import com.brahma.latestnews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}