package com.example.composekotlinstudy.ui.nav

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 首页 Tab：模拟列表点击进入详情页。
 */
@Composable
internal fun HomeTab(
    onNavigateToDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    TabContent(
        title = "首页推荐",
        description = "点击卡片或按钮可以查看文章详情，离开后底部导航栏将自动隐藏。",
        actionLabel = "打开详情页",
        onNavigateToDetail = onNavigateToDetail,
        modifier = modifier
    )
}

/**
 * 发现 Tab：展示发现内容的点击事件。
 */
@Composable
internal fun DiscoverTab(
    onNavigateToDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    TabContent(
        title = "发现新内容",
        description = "发现页同样复用导航逻辑，点击任意可交互元素即可跳转。",
        actionLabel = "查看发现详情",
        onNavigateToDetail = onNavigateToDetail,
        modifier = modifier
    )
}

/**
 * 我的 Tab：用于展示个人资料。
 */
@Composable
internal fun ProfileTab(
    onNavigateToDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    TabContent(
        title = "我的主页",
        description = "这里可以放置个人资料、设置等内容。继续点击下方卡片体验路由跳转。",
        actionLabel = "打开个人详情",
        onNavigateToDetail = onNavigateToDetail,
        modifier = modifier
    )
}

/**
 * Tab 页面通用布局。包含一个可点击的卡片与一个按钮，都会触发跳转。
 */
@Composable
private fun TabContent(
    title: String,
    description: String,
    actionLabel: String,
    onNavigateToDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onNavigateToDetail() },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "可点击卡片",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "演示在 Tab 内部触发路由跳转。点击后将进入不含底部 Tab 的详情页。",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
        Button(onClick = onNavigateToDetail) {
            Text(actionLabel)
        }
    }
}

/**
 * 不包含底部 Tab 的详情页。通过顶部 AppBar 提供返回按钮。
 */
@Composable
internal fun DetailScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "返回上一页"
                        )
                    }
                    Text(
                        text = "详情页面",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "这是一个单独的页面，没有底部导航。",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "在这里可以根据业务展示详情内容，点击下方按钮返回。",
                style = MaterialTheme.typography.bodyMedium
            )
            Button(onClick = onNavigateBack) {
                Text("返回首页")
            }
        }
    }
}
