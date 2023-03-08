package com.brahma.latestnews.data.repository.dataSourceImpl

import com.brahma.latestnews.data.api.NewsApiService
import com.brahma.latestnews.data.model.APIResponse
import com.brahma.latestnews.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService
) : NewsRemoteDataSource {

    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {
        return newsApiService.getTopHeadLines(country, page)
    }
}