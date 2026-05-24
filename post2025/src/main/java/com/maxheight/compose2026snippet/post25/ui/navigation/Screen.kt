package com.maxheight.compose2026snippet.post25.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.maxheight.compose2026snippet.post25.R
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int
) {
    @Serializable
    data object Grid : Screen(
        route = "grid",
        label = R.string.label_grid,
        icon = R.drawable.ic_grid
    )
}