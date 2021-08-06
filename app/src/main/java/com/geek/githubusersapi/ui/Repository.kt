package com.geek.githubusersapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geek.githubusersapi.core.network.Resource
import com.geek.githubusersapi.data.remote.ApiService
import com.geek.githubusersapi.model.GithubUser
import kotlinx.coroutines.Dispatchers

class Repository(private val apiService: ApiService) {

    fun fetchGithubUsers(): LiveData<Resource<List<GithubUser>?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())

        val response = apiService.fetchAllGithubUsers()

        emit(
            if (response.isSuccessful) Resource.success(
                response.body(),
                response.code()
            )
            else Resource.error(
                response.message(),
                response.code()
            )
        )
    }
}