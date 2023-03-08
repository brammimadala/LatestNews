package com.brahma.latestnews.domain.usecase

import com.brahma.latestnews.data.model.Article
import com.brahma.latestnews.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}