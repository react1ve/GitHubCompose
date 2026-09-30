package com.reactive.githubcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.reactive.githubcompose.ui.feature.repos.ReposContract
import com.reactive.githubcompose.ui.feature.repos.ReposViewModel
import com.reactive.githubcompose.ui.feature.repos.composables.ReposScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ReposScreenDestination(userId: String, navController: NavController) {
    val viewModel = koinViewModel<ReposViewModel> { parametersOf(userId) }
    ReposScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event -> viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is ReposContract.Effect.Navigation.Back) {
                navController.popBackStack()
            }
        },
    )
}
