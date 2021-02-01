package com.example.testproject.data.repository

import com.example.testproject.data.source.remote.test_project.NetworkManagerTestProject

class TestRepositoryImpl(
    private val networkManagerTestProject: NetworkManagerTestProject,
) : TestRepository {

    override suspend fun getPosts() = networkManagerTestProject.getPosts()

}
