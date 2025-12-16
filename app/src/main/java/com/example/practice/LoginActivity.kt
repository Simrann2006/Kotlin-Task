package com.example.practice

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.repository.UserRepoImpl
import com.example.practice.ui.theme.Blue
import com.example.practice.ui.theme.Light_grey
import com.example.practice.ui.theme.Light_grey1
import com.example.practice.ui.theme.White
import com.example.practice.viewmodel.UserViewModel

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginBody()
        }
    }
}

@Composable
fun LoginBody(){

    val userViewModel = remember { UserViewModel(UserRepoImpl()) }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val activity = context as Activity

    val sharedPreference = context.getSharedPreferences("User", Context.MODE_PRIVATE)

    val localEmail : String? = sharedPreference.getString("email","")
    val localPassword : String? = sharedPreference.getString("password","")

    Scaffold { padding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(White)
        ){
            Spacer(Modifier.height(60.dp))

            Text("Sign In",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Blue,
                textAlign = TextAlign.Center
                )
            )
            Text("It was popularised in the 1960s with the release of Latest sheets containing Lorem Ipsum",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Light_grey.copy(0.8f)
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ){
                SocialMediaCard(
                    Modifier
                        .height(55.dp)
                        .weight(1f),
                    R.drawable.facebook,
                    "Facebook",
                    CardDefaults.cardColors(
                        containerColor = Light_grey1
                    )
                )

                Spacer(Modifier.width(20.dp))

                SocialMediaCard(
                    Modifier
                        .height(55.dp)
                        .weight(1f),
                    R.drawable.google,
                    "Google",
                    CardDefaults.cardColors(
                        containerColor = Light_grey1
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp, horizontal = 15.dp),

                verticalAlignment = Alignment.CenterVertically
            ){
                HorizontalDivider(Modifier.weight(1f))
                Text("Or",modifier = Modifier.padding(horizontal = 15.dp))
                HorizontalDivider(Modifier.weight(1f))
            }

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

            Spacer(Modifier.height(15.dp))

            OutlinedTextField(
                value = password,

                onValueChange = { data ->
                    password = data
                },
                visualTransformation = if(visibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        visibility = !visibility
                    }) {
                        Icon(
                            painter = if (visibility)
                                painterResource(R.drawable.outline_visibility_off_24) else
                                painterResource(R.drawable.outline_visibility_24),
                            contentDescription = null
                        )
                    }
                },
                placeholder = {
                    Text("********")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Light_grey1,
                    unfocusedContainerColor = Light_grey1,
                    focusedIndicatorColor = Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Text("Forget Password?", style = TextStyle(
                textAlign =TextAlign.End),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp)
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {
                    if(email.equals("") || password.equals("")){
                        Toast.makeText(context, "Please enter all fields", Toast.LENGTH_LONG).show()

//                        val intent = Intent(context,
//                            DashboardActivity::class.java)

//                        intent.putExtra("email",email)
//                        intent.putExtra("password",password)
//                        context.startActivity(intent)
//                        activity.finish()
                    } else{
                        userViewModel.login(email, password) { success, message ->
                            if (success){
                                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                                val intent = Intent(context, DashboardActivity::class.java)
                                context.startActivity(intent)
                                activity.finish()
                            } else{
                                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 15.dp)
            ) {
                Text("Log In",style = TextStyle(
                    fontSize = 16.sp
                ))
            }

            Text(buildAnnotatedString {
                append("Don't have an account?")

                withStyle(style = SpanStyle(color = Blue)){
                    append(" Sign Up")
                }
            }, style = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .clickable{
                        val intent = Intent(context, RegistrationActivity::class.java)
                        context.startActivity(intent)
                        activity.finish()
                    }
                    .padding(horizontal = 15.dp, vertical = 15.dp)
            )
        }
    }
}

@Composable
fun SocialMediaCard(modifier: Modifier, image : Int, label : String,colors: CardColors){
    Card(
        modifier = modifier,
        colors = colors
    ){
        Row(
            modifier = Modifier
                .fillMaxSize(),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(label)
        }
    }
}

@Preview
@Composable
fun PreviewLogin(){
    LoginBody()
}