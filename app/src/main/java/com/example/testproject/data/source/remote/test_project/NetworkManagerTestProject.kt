package com.example.testproject.data.source.remote.test_project

import com.example.testproject.data.model.response.PostResponse
import retrofit2.Response

interface NetworkManagerTestProject {
    suspend fun getPosts(): Response<PostResponse>
}