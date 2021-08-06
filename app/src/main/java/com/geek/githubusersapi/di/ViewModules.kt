package com.geek.githubusersapi.di

import com.geek.githubusersapi.ui.github_users.GithubUsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { GithubUsersViewModel(get()) }
}