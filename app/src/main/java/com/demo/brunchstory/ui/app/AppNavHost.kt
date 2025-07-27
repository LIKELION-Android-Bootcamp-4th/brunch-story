package com.demo.brunchstory.ui.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.brunchstory.core.model.dummy.dummyPosts
import com.demo.brunchstory.core.model.dummy.dummyWriters
import com.demo.brunchstory.ui.detailpost.DetailPostScreen
import com.demo.brunchstory.ui.scaffold.MainScaffoldContainer
import com.demo.brunchstory.ui.home.HomeScreen
import com.demo.brunchstory.ui.mybox.MyBoxScreen
import com.demo.brunchstory.ui.search.SearchPostsScreen
import com.demo.brunchstory.ui.search.SearchScreen
import com.demo.brunchstory.ui.sign.signIn.SignInScreen
import com.demo.brunchstory.ui.sign.signUp.SignUpScreen
import com.demo.brunchstory.ui.write.WriteScreen
import com.demo.brunchstory.ui.writer.WriterProfileScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("signIn") {
            SignInScreen(navController)
        }
        composable("signUp") {
            SignUpScreen(navController)
        }
        composable("home?isLoggedIn={isLoggedIn}") { backStackEntry ->
            MainScaffoldContainer(navController) {
                val isLoggedIn = backStackEntry.arguments?.getString("isLoggedIn")?.toBoolean() ?: false
                HomeScreen(navController = navController)
            }
        }
        composable("write") {
            WriteScreen(
                onCancel = { navController.navigate("home") },
                onSave = { navController.navigate("home") }
            )
        }
        composable("search") {
            MainScaffoldContainer(navController) {
                SearchScreen(navController)
            }
        }
        composable("myBox") {
            MainScaffoldContainer(navController) {
                MyBoxScreen(navController)
            }
        }

        composable("detailPost/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            if (postId != null) {
                DetailPostScreen(postId = postId)
            }
        }

        composable("writerProfile/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            if (id != null) {
                WriterProfileScreen(navController, id = id)
            }
        }


    }

}
