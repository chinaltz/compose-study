package com.example.composekotlinstudy.ui.page

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.composekotlinstudy.ui.activity.ComposeUITextSample

    @Composable
    fun TestPageView(navController: NavHostController) {
        val context = LocalContext.current
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Text(
                    text = "普通文本 2222点击",
                    modifier = Modifier.clickable {
                        // 点击时随机修改字体颜色
                        Toast.makeText(context, "普通文本 Text被点击", Toast.LENGTH_SHORT).show()
                    }

                )
            }
        }
    }

