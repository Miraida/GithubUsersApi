package com.geek.githubusersapi.di

import com.geek.githubusersapi.ui.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { Repository(get()) }
}