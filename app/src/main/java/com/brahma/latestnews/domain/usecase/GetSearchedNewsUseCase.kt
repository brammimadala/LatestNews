package com.brahma.latestnews.domain.usecase

import com.brahma.latestnews.data.model.APIResponse
import com.brahma.latestnews.data.util.Resource
import com.brahma.latestnews.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}