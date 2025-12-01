/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.composekotlinstudy.ui.nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composekotlinstudy.ui.nav.NavigationRoutes.Root
import com.example.composekotlinstudy.ui.nav.NavigationRoutes.Tab

/**
 * 对外暴露的入口。App 只需要在 Activity 中调用该方法即可完成所有导航逻辑。
 */
@Composable
fun TabBarPage(modifier: Modifier = Modifier) {
    val rootNavController = rememberNavController()
    NavHost(
        navController = rootNavController,
        startDestination = Root.MAIN,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Root.MAIN) {
            TabHomeScreen(
                rootNavController = rootNavController,
            )
        }
        composable(Root.DETAIL) {
            DetailScreen(
                onNavigateBack = { rootNavController.popBackStack() }
            )
        }
    }
}

/**
 * 底部 Tab 所在的首页。内部再维护一个子 NavController 管理 Tab 之间的切换。
 */
@Composable
private fun TabHomeScreen(
    rootNavController: NavHostController,
    modifier: Modifier = Modifier
) {
    val tabNavController = rememberNavController()
    val tabBackStackEntry by tabNavController.currentBackStackEntryAsState()
    val currentRoute = tabBackStackEntry?.destination?.route ?: Tab.HOME.route

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                Tab.entries.forEach { destination ->
                    val isSelected = currentRoute == destination.route
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            if (!isSelected) {
                                tabNavController.navigate(destination.route) {
                                    launchSingleTop = true
                                    popUpTo(tabNavController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    restoreState = true
                                }
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = destination.icon,
                                contentDescription = destination.contentDescription
                            )
                        },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        TabNavGraph(
            tabNavController = tabNavController,
            onNavigateToDetail = {
                rootNavController.navigate(Root.DETAIL)
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

/**
 * Tab 内部的导航图，负责将路由字符串与对应的页面绑定。
 */
@Composable
private fun TabNavGraph(
    tabNavController: NavHostController,
    onNavigateToDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = tabNavController,
        startDestination = Tab.HOME.route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Tab.HOME.route) {
            HomeTab(onNavigateToDetail)
        }
        composable(Tab.DISCOVER.route) {
            DiscoverTab(onNavigateToDetail)
        }
        composable(Tab.PROFILE.route) {
            ProfileTab(onNavigateToDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TabBarPreview() {
    TabBarPage()
}
