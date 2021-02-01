package com.example.testproject.data.source.remote.test_project

import com.example.testproject.data.model.response.PostResponse
import com.example.testproject.util.contants.NetworkConstants
import retrofit2.Response
import retrofit2.http.GET


interface TestProjectApi {
    @GET(NetworkConstants.POSTS)
    suspend fun getPosts(): Response<PostResponse>

}