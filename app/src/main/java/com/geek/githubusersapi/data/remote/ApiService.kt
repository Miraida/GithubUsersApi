package com.geek.githubusersapi.data.remote

import com.geek.githubusersapi.model.GithubUser
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
   suspend fun fetchAllGithubUsers(): Response<List<GithubUser>>
}