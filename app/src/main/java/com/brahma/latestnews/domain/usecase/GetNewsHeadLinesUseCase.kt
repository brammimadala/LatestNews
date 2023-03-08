package com.brahma.latestnews.domain.usecase

import com.brahma.latestnews.data.model.APIResponse
import com.brahma.latestnews.data.util.Resource
import com.brahma.latestnews.domain.repository.NewsRepository

class GetNewsHeadLinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int):Resource<APIResponse>{
        return newsRepository.getNewsHeadLines(country,page)
    }
}