package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainBody()
        }
    }
}

@Composable
fun MainBody(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize() //all size screen
            .background(color = Color.Yellow)
//            .height(50.dp)
//            .width( 50.dp)
//              .size(50.dp) //if height and width is same
    ){
        Text("Hello", style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            fontStyle = FontStyle.Italic,
//            color = Color.Blue,
            color = colorResource(R.color.pink),  //customize color
            textAlign = TextAlign.Justify
        ))

        Text("Android",style = TextStyle(
            fontSize = 20.sp
        ))

        Image(
            painter = painterResource(R.drawable.image),
            contentDescription = null,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        )
    }
}

// layout related dp, text related sp

@Preview
@Composable
fun PreviewBody(){
    MainBody()
}