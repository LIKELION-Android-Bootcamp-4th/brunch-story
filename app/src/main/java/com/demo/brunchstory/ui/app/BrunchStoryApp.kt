package com.demo.brunchstory.ui.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BrunchStoryApp() {
    val navController = rememberNavController()
    AppNavHost(navController = navController)
}