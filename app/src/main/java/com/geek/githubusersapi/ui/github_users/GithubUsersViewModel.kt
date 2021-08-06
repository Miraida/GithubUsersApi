package com.geek.githubusersapi.ui.github_users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geek.githubusersapi.core.network.Resource
import com.geek.githubusersapi.model.GithubUser
import com.geek.githubusersapi.ui.Repository

class GithubUsersViewModel(private val repo: Repository) : ViewModel() {

    fun fetchGithubUsers():LiveData<Resource<List<GithubUser>?>>{
        return repo.fetchGithubUsers()
    }

    val loading = MutableLiveData<Boolean>()
}