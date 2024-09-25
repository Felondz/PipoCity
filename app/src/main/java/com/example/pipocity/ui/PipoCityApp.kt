package com.example.pipocity.ui


import android.content.res.Configuration
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalConfiguration
import com.example.pipocity.ui.utils.PipoCityNavigationType
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PipoCityApp(
    windowSize: WindowWidthSizeClass
) {
    val navigationType: PipoCityNavigationType
    val viewModel: PipocityViewModel = viewModel()
    val pipoCityUiState = viewModel.uiState.collectAsState().value
    val configuration = LocalConfiguration.current
    val orientation = configuration.orientation

    navigationType = when {
        windowSize == WindowWidthSizeClass.Expanded -> {
            PipoCityNavigationType.PERMANENT_NAVIGATION_DRAWER
        }

        windowSize == WindowWidthSizeClass.Medium || (windowSize == WindowWidthSizeClass.Compact && orientation == Configuration.ORIENTATION_LANDSCAPE) -> {
            PipoCityNavigationType.NAVIGATION_RAIL
        }

        else -> { // Compact y Portrait
            PipoCityNavigationType.BOTTOM_NAVIGATION
        }
    }
    viewModel.updateNavigationType(navigationType = navigationType)

    viewModel.onDetailsExpandedChange(navigationType == PipoCityNavigationType.PERMANENT_NAVIGATION_DRAWER)
    val navController = rememberNavController()
    SideEffect {if (navigationType == PipoCityNavigationType.PERMANENT_NAVIGATION_DRAWER)
        navController.navigate("home"){
            popUpTo("home"){inclusive = true}
        }}

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            PipoCityHomeScreen(pipoCityUiState = pipoCityUiState,
                viewModel = viewModel,
                navController = navController,
                onTabPressed = { pipoCityNavigationCategory ->
                    viewModel.updateCurrentCategory(pipoCityNavigationCategory = pipoCityNavigationCategory)
                    viewModel.resetHomeScreenStates()
                })
        }
        composable("details_screen") {
            PipoCityDetailsScreen(pipoCityUiState = pipoCityUiState,
                viewModel = viewModel,
                onBackPressed = { navController.popBackStack() })
        }
    }
}
