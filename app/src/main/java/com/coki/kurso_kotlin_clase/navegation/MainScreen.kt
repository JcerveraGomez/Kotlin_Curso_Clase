package com.coki.kurso_kotlin_clase.navegation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.coki.kurso_kotlin_clase.Routes
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

@Composable
fun MainScreen(activity: Activity){


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route) {

        composable(Routes.Home.route) {
            HomeScreen(navController = navController,activity)
        }
        composable(Routes.Login.route) {
            LoginScreen(navController = navController,activity)
        }


    }
}
