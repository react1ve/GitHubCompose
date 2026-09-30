package com.reactive.githubcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.reactive.githubcompose.ui.feature.users.UsersContract
import com.reactive.githubcompose.ui.feature.users.UsersViewModel
import com.reactive.githubcompose.ui.feature.users.composables.UsersScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun UsersScreenDestination(navController: NavController) {
    val viewModel = koinViewModel<UsersViewModel>()
    UsersScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event ->  viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is UsersContract.Effect.Navigation.ToRepos) {
                navController.navigateToRepos(navigationEffect.userId)
            }
        }
    )
}
