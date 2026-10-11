
package com.example.superheroparcial.navigation

sealed class Screen(val route: String) {

    data object Home : Screen("home")

    data object Detail : Screen("detail/{heroId}") {

        fun createRoute(heroId: Int): String {
            return "detail/$heroId"
        }
    }
}
