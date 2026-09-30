package com.reactive.githubcompose.ui.feature.repos

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.reactive.githubcompose.data.model.RepoPreview
import com.reactive.githubcompose.data.model.buildUserDetailPreview
import com.reactive.githubcompose.ui.feature.repos.composables.ReposScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ReposScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun reposScreen_successState_showsUserDetailsAndRepos() {
        val userDetail = buildUserDetailPreview()
        val repo = RepoPreview.repo
        composeTestRule.setContent {
            ReposScreen(
                state = ReposContract.State(
                    user = userDetail,
                    reposList = listOf(repo),
                    isUserLoading = false,
                    isReposLoading = false,
                    isError = false
                ),
                effectFlow = null,
                onEventSent = {},
                onNavigationRequested = {}
            )
        }

        composeTestRule.onNodeWithText(userDetail.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(repo.name).assertIsDisplayed()
    }

    @Test
    fun reposScreen_errorState_showsError() {
        composeTestRule.setContent {
            ReposScreen(
                state = ReposContract.State(
                    user = null,
                    reposList = emptyList(),
                    isUserLoading = false,
                    isReposLoading = false,
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
