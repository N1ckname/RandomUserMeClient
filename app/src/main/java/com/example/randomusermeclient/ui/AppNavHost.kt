package com.example.randomusermeclient.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.randomusermeclient.ui.screens.SingleUserScreen
import com.example.randomusermeclient.ui.screens.UsersScreen

@Composable
fun AppNavHost(
    viewModel: UsersViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = "Users",
    ) {
        composable(
            route = "Users",
        ) {
            UsersScreen(
                usersSummaries = viewModel.users,
                onItemClick = { userId ->
                    navController.navigate("SingleUser/${userId}") {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = "SingleUser/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType }),
        ) { navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getInt("userId") ?: -1

            if (userId < 0) {
                navController.navigate("Users") {
                    launchSingleTop = true
                }
            }

            SingleUserScreen(
                userProvider = { viewModel.getUser(userId) }
            )
        }
    }
}