package com.example.superheroparcial.navigation
sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Detail : Routes("detail/{heroId}") {
        fun create(heroId: Int) = "detail/$heroId"
    }
}
