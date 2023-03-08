package com.brahma.latestnews.presentation.di

import com.brahma.latestnews.data.api.NewsApiService
import com.brahma.latestnews.data.repository.dataSource.NewsRemoteDataSource
import com.brahma.latestnews.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsApiService: NewsApiService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }

}

