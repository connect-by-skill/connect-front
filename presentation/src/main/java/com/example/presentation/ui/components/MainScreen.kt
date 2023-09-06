package com.example.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.presentation.model.MainMenu
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.theme.colors
import com.example.presentation.theme.menuSmall
import com.example.presentation.viewmodel.WishListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController : NavHostController) {
    val mainNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            MainNavigationBar(navController = mainNavController)
        }
    ) {paddingValues ->
        MainNavigationScreen(
            mainNavController, paddingValues)
    }
}

@Composable
fun MainNavigationBar(navController: NavHostController) {
    val bottomNavigationItems = listOf(
        MainMenu.Home,
        MainMenu.Recruit,
        MainMenu.Recommend,
        MainMenu.WishList,
        MainMenu.MyPage,
    )

    NavigationBar(
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach {item ->
            NavigationBarItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.res),
                            contentDescription = item.name,
                            modifier = Modifier.size(36.dp),
                            tint = if(currentRoute == item.name) MaterialTheme.colors.surface else MaterialTheme.colors.primary
                        )
                        Text(
                            text = item.name,
                            color = if(currentRoute == item.name) MaterialTheme.colors.surface else MaterialTheme.colors.primary,
                            style = when(item.name) {
                                MainMenu.WishList.name, MainMenu.MyPage.name -> {
                                    MaterialTheme.typography.menuSmall
                                }
                                else ->{
                                    MaterialTheme.typography.labelMedium
                                }
                            }
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colors.primary),
                selected = currentRoute == item.name,
                onClick = {
                    navController.navigate(item.name) {
                        navController.graph?.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


@Composable
fun MainNavigationScreen(navController : NavHostController, paddingValues: PaddingValues) {
    val wishListViewModel = hiltViewModel<WishListViewModel>()
    NavHost(
        navController = navController,
        startDestination = MainMenu.Home.name,
        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        composable(route = MainMenu.Home.name){
            HomeScreen(navController)
        }
        composable(route = MainMenu.Recruit.name){
            RecruitScreen()
        }
        composable(route = MainMenu.Recommend.name){
            RecommendScreen()
        }
        composable(route = MainMenu.WishList.name){
            wishListViewModel.getWishList()
            WishListScreen(viewModel = wishListViewModel)
        }
        composable(route = MainMenu.MyPage.name){
            MyPageScreen()
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    WhaleTheme {
        MainScreen(navController = rememberNavController())
    }
}