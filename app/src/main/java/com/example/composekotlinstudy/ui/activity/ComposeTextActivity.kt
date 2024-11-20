package com.example.composekotlinstudy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.composekotlinstudy.ui.theme.ComposeKotlinStudyTheme

class ComposeTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 适配顶部导航栏
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ComposeKotlinStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeUITextSample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(
        text = "Hello $name!"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposeKotlinStudyTheme {
        Greeting2("Android")
    }
}


@Composable
fun ComposeUITextSample(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
// 可以点击 的文本
        val context = LocalContext.current
        ClickableText(
            text = AnnotatedString("ClickableText  基本使用"),
            onClick = { offset ->
                // Handle click event here
                Toast.makeText(context, "ClickableText 被点击", Toast.LENGTH_SHORT).show()

            }
        )

// 普通文本的点击 事件
        Text(
            text = "普通文本 点击",
            modifier = Modifier.clickable {
                // 点击时随机修改字体颜色
                Toast.makeText(context, "普通文本 Text被点击", Toast.LENGTH_SHORT).show()
            }

        )

    }
}