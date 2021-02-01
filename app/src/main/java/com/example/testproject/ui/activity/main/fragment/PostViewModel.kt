package com.example.testproject.ui.activity.main.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.data.model.NetworkResponse
import com.example.testproject.data.model.response.PostResponse

abstract class PostViewModel: ViewModel() {
    abstract fun getPosts()
    abstract fun getPostsData(): MutableLiveData<NetworkResponse<PostResponse>>
}