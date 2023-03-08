package com.brahma.latestnews.data.repository.dataSource

import com.brahma.latestnews.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse>
}