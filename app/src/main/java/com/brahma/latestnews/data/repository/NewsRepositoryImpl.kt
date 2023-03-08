package com.brahma.latestnews.data.repository

import com.brahma.latestnews.data.model.APIResponse
import com.brahma.latestnews.data.model.Article
import com.brahma.latestnews.data.repository.dataSource.NewsRemoteDataSource
import com.brahma.latestnews.data.util.Resource
import com.brahma.latestnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    override suspend fun getNewsHeadLines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadLines(country,page))
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {

        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }

        }
        return Resource.Error(response.message())
    }

}