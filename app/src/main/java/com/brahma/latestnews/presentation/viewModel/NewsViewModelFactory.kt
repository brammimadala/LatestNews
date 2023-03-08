package com.brahma.latestnews.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brahma.latestnews.domain.usecase.GetNewsHeadLinesUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadLinesUseCase: GetNewsHeadLinesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadLinesUseCase
        ) as T
    }

}