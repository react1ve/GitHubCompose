package com.reactive.githubcompose.ui.feature.users

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.reactive.githubcompose.data.model.buildUserPreview
import com.reactive.githubcompose.ui.feature.users.composables.UsersScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UsersScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun usersScreen_loadingState_showsProgress() {
        composeTestRule.setContent {
            UsersScreen(
                state = UsersContract.State(
                    users = emptyList(),
                    isLoading = true,
                    isError = false
                ),
                effectFlow = null,
                onEventSent = {},
                onNavigationRequested = {}
            )
        }
    }

    @Test
    fun usersScreen_successState_showsUsers() {
        val user = buildUserPreview()
        composeTestRule.setContent {
            UsersScreen(
                state = UsersContract.State(
                    users = listOf(user),
                    isLoading = false,
                    isError = false
                ),
                effectFlow = null,
                onEventSent = {},
                onNavigationRequested = {}
            )
        }

        composeTestRule.onNodeWithText(user.userId).assertIsDisplayed()
    }

    @Test
    fun usersScreen_errorState_showsError() {
        composeTestRule.setContent {
            UsersScreen(
                state = UsersContract.State(
                    users = emptyList(),
                    isLoading = false,
                    isError = true
                ),
                effectFlow = null,
                onEventSent = {},
                onNavigationRequested = {}
            )
        }

        composeTestRule.onNodeWithText("Oh no!").assertIsDisplayed()
    }
}
