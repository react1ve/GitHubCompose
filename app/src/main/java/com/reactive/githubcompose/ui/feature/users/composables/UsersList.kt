package com.reactive.githubcompose.ui.feature.users.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reactive.githubcompose.data.model.User
import com.reactive.githubcompose.data.model.buildUserPreview

@Composable
fun UsersList(
    users: List<User>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onItemClick: (User) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .consumeWindowInsets(contentPadding),
        contentPadding = contentPadding
    ) {
        item {
            UsersListHeader()
        }
        items(users) { user ->
            UsersListItem(user = user, onItemClick = onItemClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsersListPreview() {
    val users = List(3) { buildUserPreview() }
    UsersList(users = users) {}
}
