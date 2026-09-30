package com.reactive.githubcompose.data

import com.reactive.githubcompose.data.model.Repo
import com.reactive.githubcompose.data.model.User
import com.reactive.githubcompose.data.model.UserDetail

interface GithubRepository {
    suspend fun getUsers(): Result<List<User>>
    suspend fun getUser(userId: String): Result<UserDetail?>
    suspend fun getRepos(userId: String): Result<List<Repo>>
}
