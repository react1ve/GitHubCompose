package com.reactive.githubcompose.ui.feature.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.reactive.githubcompose.R

@Composable
fun RoundedImage(
    url: String,
    @DrawableRes placeholder: Int,
    modifier: Modifier = Modifier,
    crossfade: Boolean = true,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(crossfade)
            .placeholder(placeholder)
            .transformations(CircleCropTransformation())
            .build(),
        contentDescription = null,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun RoundedImagePreview() {
    RoundedImage(
        url = "",
        placeholder = R.drawable.avatar_placeholder,
        modifier = Modifier.size(dimensionResource(id = R.dimen.avatar_size_medium))
    )
}
