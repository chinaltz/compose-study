package com.example.composekotlinstudy.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * 统一管理应用中的路由声明，方便集中查阅与维护。
 */
object NavigationRoutes {

    /**
     * 顶层路由：区分带底部 Tab 的首页与详情页。
     */
    object Root {
        const val MAIN = "main"
        const val DETAIL = "detail"
    }

    /**
     * 底部 Tab 对应的子路由与元数据。
     */
    enum class Tab(
        val route: String,
        val label: String,
        val icon: ImageVector,
        val contentDescription: String
    ) {
        HOME("tab/home", "首页", Icons.Filled.Home, "首页"),
        DISCOVER("tab/discover", "发现", Icons.Filled.Place, "发现"),
        PROFILE("tab/profile", "我的", Icons.Filled.AddCircle, "我的")
    }
}
