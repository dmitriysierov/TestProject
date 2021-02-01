package com.example.testproject.di

import com.example.testproject.ui.activity.main.fragment.PostViewModel
import com.example.testproject.ui.activity.main.fragment.PostViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {

        viewModel<PostViewModel> {
            PostViewModelImpl(get())
        }
    }
}