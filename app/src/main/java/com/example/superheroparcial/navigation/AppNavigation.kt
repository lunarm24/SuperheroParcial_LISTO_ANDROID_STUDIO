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

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Detail : Routes("detail/{heroId}") {
        fun create(heroId: Int) = "detail/$heroId"
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(Routes.Home.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val state by viewModel.uiState.collectAsStateWithLifecycle()
                HomeScreen(
                    state = state,
                    onHeroClick = { navController.navigate(Routes.Detail.create(it)) },
                    onRetry = viewModel::loadHeroes
                )
            }
            composable(
                Routes.Detail.route,
                arguments = listOf(navArgument("heroId") { type = NavType.IntType })
            ) { entry ->
                val id = requireNotNull(entry.arguments).getInt("heroId")
                val viewModel: DetailViewModel = hiltViewModel()
                val state by viewModel.uiState.collectAsStateWithLifecycle()
                LaunchedEffect(id) { viewModel.loadHero(id) }
                DetailScreen(
                    state = state,
                    onBack = { navController.popBackStack() },
                    onRetry = { viewModel.loadHero(id) }
                )
            }
        }
    }
}
