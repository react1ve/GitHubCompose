package com.reactive.githubcompose.di

import com.reactive.githubcompose.data.GithubRepository
import com.reactive.githubcompose.data.GithubRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<GithubRepository> {
        GithubRepositoryImpl(
            githubApi = get()
        )
    }
}
