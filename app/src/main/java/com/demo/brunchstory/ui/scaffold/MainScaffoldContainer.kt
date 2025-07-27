package com.demo.brunchstory.ui.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.demo.brunchstory.viewmodel.BottomNavigationViewModel
import com.demo.brunchstory.ui.navigation.BottomNavigationBar

@Composable
fun MainScaffoldContainer(
    navController: NavController,
    content: @Composable () -> Unit
) {
    val viewModel: BottomNavigationViewModel = viewModel() // ViewModel 사용
    val selectedIndex = viewModel.selectedIndex

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        bottomBar = {
            if (selectedIndex != 2) {
                BottomNavigationBar(
                    selectedIndex = selectedIndex,
                    onTabSelected = { index ->
                        viewModel.selectedIndex = index
                        when (index) {
                            0 -> navController.navigate("home")
                            1 -> navController.navigate("search")
                            2 -> navController.navigate("write")
                            3 -> navController.navigate("myBox")
                        }
                    }
                )
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                content()
            }
        }
    )
}
