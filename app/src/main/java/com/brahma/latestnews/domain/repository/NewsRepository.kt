package com.brahma.latestnews.domain.repository

import com.brahma.latestnews.data.model.APIResponse
import com.brahma.latestnews.data.model.Article
import com.brahma.latestnews.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadLines(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>

    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)

    fun getSavedNews(): Flow<List<Article>>
}