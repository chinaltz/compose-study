package com.example.composekotlinstudy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composekotlinstudy.R
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


@Preview(showBackground = true)
@Composable
fun ComposeUITextSample(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
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
//设置  padding  先设置 背景 再设置 padding  设置的是 padding
        Text(
            text = "设置 padding  ",
            modifier = Modifier
                .background(Color.Red)
                .padding(15.dp)


        )
//设置 margin  先设置 padding 再设置 背景 是 margin  （用约束布局 这太容易出错了）

        Text(
            text = "设置 padding 再设置 背景 是 margin  ",
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Red)
        )
//    设置 offset
        Text(
            text = "设置 offset   距离左边 和顶部 距离 ",
            modifier = Modifier
//                .offset(20.dp, 15.dp)
                .background(Color.Red)

        )
//        设置字体 字体大小  字体颜色 字重 字间距
        val fontFamily = FontFamily(
            Font(resId = R.font.wgtres_fontroboto_bold, weight = FontWeight.Normal)
        )
        Text(

            text = "设置 字体  字重 字间距 字体大小 字体颜色  line height 超一行才可以生效",
            modifier = Modifier
                .padding(10.dp),
//            设置 font下字体
            style = TextStyle(
                fontFamily = fontFamily,
                //字间距
                letterSpacing = 2.sp,
//            字重
                fontWeight = FontWeight.Bold,
//            字体颜色
                color = Color.Black,
//            字体大小
                fontSize = 18.sp,
                lineHeight = 80.sp,
            )

        )


        val  longText="长文本".repeat(80)
        Text( text = longText)

    }


}