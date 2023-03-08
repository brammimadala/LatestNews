package com.brahma.latestnews.domain.usecase

import com.brahma.latestnews.data.model.Article
import com.brahma.latestnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute():Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}