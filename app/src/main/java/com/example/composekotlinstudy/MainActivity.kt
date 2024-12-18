
package com.example.composekotlinstudy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.composekotlinstudy.ui.activity.ComposeTextActivity
import com.example.composekotlinstudy.ui.theme.ComposeKotlinStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val context = this
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 适配顶部导航栏
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ComposeKotlinStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    studyMenus(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun  studyMenus(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Column(modifier = modifier) {
        ClickableText(
            text = AnnotatedString("Text 基本使用")
            ,
            onClick = { offset ->
                // Handle click event here
                context.startActivity(Intent(context, ComposeTextActivity::class.java))

            }
        )
        Text(text = "Column 基础")

    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeKotlinStudyTheme {
        studyMenus()
    }
}