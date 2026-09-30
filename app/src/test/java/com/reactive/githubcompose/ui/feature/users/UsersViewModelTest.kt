package com.reactive.githubcompose.ui.feature.users

import androidx.compose.runtime.snapshots.Snapshot
import com.reactive.githubcompose.MainCoroutineRule
import com.reactive.githubcompose.data.GithubRepository
import com.reactive.githubcompose.data.model.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@DelicateCoroutinesApi
@OptIn(ExperimentalCoroutinesApi::class)
class UsersViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val githubRepository = mockk<GithubRepository>()

    @Test
    fun `When view model initialized then should emit initial view state first`() = runTest {
        // Given
        val expectedViewState = UsersContract.State(
            users = emptyList(),
            isLoading = false,
            isError = false
        )
        coEvery { githubRepository.getUsers() } returns Result.success(emptyList())

        // When
        val viewModel = UsersViewModel(githubRepository)

        // Then
        assertEquals(expectedViewState, viewModel.viewState.value)
    }

    @Test
    fun `When getUsers called then should emit a view state`() = runTest {
        // Given
        val users = listOf(User(userId = "51234843"))
        val expectedViewState = UsersContract.State(
            users = users,
            isLoading = false,
            isError = false
        )
        coEvery { githubRepository.getUsers() } returns Result.success(users)

        // When
        val viewModel = UsersViewModel(githubRepository)

        // Then
        assertEquals(expectedViewState, viewModel.viewState.value)
    }

    @Test
    fun `When snapshot enter then should emit view state`() = runTest {
        // Given
        val users = listOf(User(userId = "51234843"))
        val expectedViewState = UsersContract.State(
            users = users,
            isLoading = false,
            isError = false
        )
        coEvery { githubRepository.getUsers() } returns Result.success(users)

        // When
        val snapshot = Snapshot.takeMutableSnapshot(
            writeObserver = {
                println(it)
            }
        )

        snapshot.enter {
            val viewModel = UsersViewModel(githubRepository)

            // Then
            assertEquals(expectedViewState, viewModel.viewState.value)
        }

        snapshot.apply()
    }

}
