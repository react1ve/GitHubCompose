package com.reactive.githubcompose.ui.feature.users.composables

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.reactive.githubcompose.R

@Composable
fun UsersTopBar() {
    TopAppBar(
        modifier = Modifier.statusBarsPadding(),
        title = { Text(text = stringResource(R.string.users_screen_top_bar_title)) }
    )
}

@Preview(showBackground = true)
@Composable
fun ReposTopBarPreview() {
    UsersTopBar()
}
