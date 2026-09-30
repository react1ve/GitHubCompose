package com.reactive.githubcompose.ui.feature.repos.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reactive.githubcompose.data.model.Repo
import com.reactive.githubcompose.data.model.RepoPreview

@Composable
fun ReposList(
    header: @Composable () -> Unit,
    reposList: List<Repo>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .consumeWindowInsets(contentPadding),
        contentPadding = contentPadding
    ) {
        item { header() }
        items(reposList) { repo ->
            ReposListItem(repo = repo)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReposListPreview() {
    val repos = List(3) { RepoPreview.repo }
    ReposList(header = {}, reposList = repos)
}
