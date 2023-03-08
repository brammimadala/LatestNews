package com.brahma.latestnews.domain.usecase

import com.brahma.latestnews.data.model.Article
import com.brahma.latestnews.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}