package com.geek.githubusersapi.di

import com.geek.githubusersapi.data.remote.networkModule

val koinModules = listOf(
    viewModules,
    networkModule,
    repositoryModule
)