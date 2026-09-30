package com.reactive.githubcompose.ui.feature.repos.composables

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.reactive.githubcompose.R

@Composable
fun ReposTopBar(onBackButtonClicked: () -> Unit) {
    TopAppBar(
        modifier = Modifier.statusBarsPadding(),
        title = { Text(text = stringResource(R.string.repos_screen_top_bar_title)) },
        navigationIcon = {
            IconButton(onClick = { onBackButtonClicked() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ReposTopBarPreview() {
    ReposTopBar {}
}
