package com.example.practice

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.repository.UserRepoImpl
import com.example.practice.ui.theme.Blue
import com.example.practice.ui.theme.Light_grey
import com.example.practice.ui.theme.Light_grey1
import com.example.practice.ui.theme.PracticeTheme
import com.example.practice.ui.theme.White
import com.example.practice.viewmodel.UserViewModel

class ForgotActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgotBody()
        }
    }
}

@Composable
fun ForgotBody(){
    val userViewModel = remember { UserViewModel(UserRepoImpl()) }

    var email by remember { mutableStateOf("") }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(White)
        ) {
            Spacer(Modifier.height(60.dp))

            Text(
                "Forgot Password?",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue,
                    textAlign = TextAlign.Center
                )
            )

            OutlinedTextField(
                value = email,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                onValueChange = { data ->
                    email = data
                },
                placeholder = {
                    Text("abc@gmail.com")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape((15.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Light_grey1,
                    unfocusedContainerColor = Light_grey1,
                    focusedIndicatorColor = Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 15.dp)
            ) {
                Text("Send Reset Link",style = TextStyle(
                    fontSize = 16.sp
                ))
            }
        }
    }
}

@Preview
@Composable
fun PreviewForgot() {
    ForgotBody()
}