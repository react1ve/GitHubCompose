package com.reactive.githubcompose.ui.feature.users

import androidx.lifecycle.viewModelScope
import com.reactive.githubcompose.data.GithubRepository
import com.reactive.githubcompose.data.model.User
import com.reactive.githubcompose.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class UsersViewModel(
    private val githubRepository: GithubRepository
) : BaseViewModel<UsersContract.Event, UsersContract.State, UsersContract.Effect>() {

    init { getUsers() }

    override fun setInitialState() = UsersContract.State(
        users = emptyList(),
        isLoading = true,
        isError = false,
    )

    override fun handleEvents(event: UsersContract.Event) {
        when (event) {
            is UsersContract.Event.UserSelection -> setEffect { UsersContract.Effect.Navigation.ToRepos(event.user.userId) }
            is UsersContract.Event.Retry -> getUsers()
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            setState { copy(isLoading = true, isError = false) }

            githubRepository.getUsers()
                .onSuccess { users ->
                    val mutableUsers = users.toMutableList()
                    val myProfile = User(
                        userId = "react1ve",
                        avatarUrl = "https://avatars.githubusercontent.com/u/0?v=4",
                        htmlUrl = "https://github.com/react1ve"
                    )
                    mutableUsers.removeAll { it.userId.equals("react1ve", ignoreCase = true) }
                    mutableUsers.add(0, myProfile)

                    setState { copy(users = mutableUsers, isLoading = false) }
                    setEffect { UsersContract.Effect.DataWasLoaded }
                }
                .onFailure {
                    setState { copy(isError = true, isLoading = false) }
                }
        }
    }
}
