package com.example.superheroparcial.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.superheroparcial.ui.home.HomeScreen
import com.example.superheroparcial.ui.home.HomeViewModel
import com.example.superheroparcial.ui.detail.DetailScreen
import com.example.superheroparcial.ui.detail.DetailViewModel
@Composable fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.Home.route, modifier = modifier) {
        composable(Routes.Home.route) {
            val vm: HomeViewModel = hiltViewModel()
            val state by vm.uiState.collectAsStateWithLifecycle()
            HomeScreen(
                state = state,
                onHeroClick = { navController.navigate(Routes.Detail.create(it)) },
                onSearchQueryChange = vm::updateSearchQuery,
                onRetry = vm::loadHeroes
            )
        }
        composable(Routes.Detail.route, arguments = listOf(navArgument("heroId") { type = NavType.IntType })) { entry ->
            val id = requireNotNull(entry.arguments).getInt("heroId")
            val vm: DetailViewModel = hiltViewModel()
            val state by vm.uiState.collectAsStateWithLifecycle()
            LaunchedEffect(id) { vm.loadHero(id) }
            DetailScreen(
                state = state,
                onBack = { navController.popBackStack() },
                onRetry = { vm.loadHero(id) }
            )
        }
    }
}
