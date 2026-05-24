package com.maxheight.compose2026snippet.post25

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.text.contextmenu.builder.item
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maxheight.compose2026snippet.post25.ui.navigation.Screen
import com.maxheight.compose2026snippet.post25.ui.screen.grid.GridScreen
import com.maxheight.compose2026snippet.post25.ui.theme.Compose2026SnippetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose2026SnippetTheme {
                Compose2026SnippetApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun Compose2026SnippetApp() {
    val screens = listOf(Screen.Grid)

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            screens.forEach { screen ->
                val isSelected = currentDestination?.hasRoute(screen::class) == true

                item(
                    icon = {
                        Icon(
                            painter = painterResource(screen.icon),
                            contentDescription = stringResource(screen.label)
                        )
                    },
                    label = {
                        Text(stringResource(screen.label))
                    },
                    selected = isSelected,
                    onClick = {
                        navController.navigate(screen) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Grid
        ) {
            composable<Screen.Grid> { GridScreen() }
        }
    }
}