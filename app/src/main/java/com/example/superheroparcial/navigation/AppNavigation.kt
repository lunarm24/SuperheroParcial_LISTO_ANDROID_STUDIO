package com.example.superheroparcial.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.superheroparcial.ui.detail.DetailScreen
import com.example.superheroparcial.ui.detail.DetailViewModel
import com.example.superheroparcial.ui.home.HomeScreen
import com.example.superheroparcial.ui.home.HomeViewModel

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            composable(Screen.Home.route) {

                val viewModel: HomeViewModel = hiltViewModel()

                val state by viewModel.uiState.collectAsStateWithLifecycle()

                HomeScreen(
                    state = state,
                    onHeroClick = { heroId ->
                        navController.navigate(
                            Screen.Detail.createRoute(heroId)
                        )
                    },
                    onRetry = viewModel::loadHeroes
                )
            }

            composable(
                route = Screen.Detail.route,
                arguments = listOf(
                    navArgument("heroId") {
                        type = NavType.IntType
                    }
                )
            ) { entry ->

                val heroId = requireNotNull(
                    entry.arguments
                ).getInt("heroId")

                val viewModel: DetailViewModel = hiltViewModel()

                val state by viewModel.uiState.collectAsStateWithLifecycle()

                LaunchedEffect(heroId) {
                    viewModel.loadHero(heroId)
                }

                DetailScreen(
                    state = state,
                    onBack = {
                        navController.popBackStack()
                    },
                    onRetry = {
                        viewModel.loadHero(heroId)
                    }
                )
            }
        }
    }
}
