package com.example.testproject.data.source.remote.test_project

class NetworkManagerTestProjectImpl(private val testProjectApi: TestProjectApi):
    NetworkManagerTestProject {

    override suspend fun getPosts() = testProjectApi.getPosts()
}