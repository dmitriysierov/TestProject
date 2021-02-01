package com.example.testproject.data.repository

import com.example.testproject.data.model.response.PostResponse
import retrofit2.Response

interface TestRepository {
    suspend fun getPosts(): Response<PostResponse>
}
