package com.example.testproject.ui.activity.main.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testproject.data.model.NetworkResponse
import com.example.testproject.data.model.response.PostResponse
import com.example.testproject.data.repository.TestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModelImpl(private val testRepository: TestRepository): PostViewModel() {

    private val postsData = MutableLiveData<NetworkResponse<PostResponse>>()

    override fun getPostsData() = postsData

    override fun getPosts() {
        viewModelScope.launch {
            runCatching {
                postsData.value = NetworkResponse.Loading(true)
                testRepository.getPosts()
            }
                .onSuccess {
                    postsData.value = NetworkResponse.Loading(false)
                    postsData.value = NetworkResponse.Success(it.body())
                }
                .onFailure {
                    postsData.value = NetworkResponse.Loading(false)
                    postsData.value = NetworkResponse.Failure(it)
                }
        }
    }
}