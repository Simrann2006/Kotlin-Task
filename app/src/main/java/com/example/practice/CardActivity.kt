package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardBody()
        }
    }
}

@Composable
fun CardBody(){
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.card))
                .padding(15.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.End
            ){
                Image(painter = painterResource(R.drawable.pp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()

            ){
                Text("Card",style = TextStyle(
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.SemiBold
                ))
                Text("Simple and easy to use app",style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                ))
            }

            Spacer(Modifier.height(55.dp))

            //Row 1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Card (
                    modifier = Modifier
                        .height(170.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                        ){
                        Image(painter = painterResource(R.drawable.text),
                            contentDescription = null,
                            modifier = Modifier
                                .size(70.dp)
                        )
                        Spacer(Modifier.height(5.dp))
                        Text("Text",style = TextStyle(
                            fontSize = 20.sp
                        ))
                        Text("Notes & messages", style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        ))
                    }
                }

                Spacer(modifier = Modifier.width(13.dp))

                Card (
                    modifier = Modifier
                        .height(170.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                        ){
                        Image(painter = painterResource(R.drawable.address),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                        Spacer(Modifier.height(5.dp))
                        Text("Address",style = TextStyle(
                            fontSize = 20.sp
                        ))
                        Text("Location info", style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        ))
                    }
                }
            }

            Spacer(Modifier.height(13.dp))

            //Row 2
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Card (
                    modifier = Modifier
                        .height(170.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(painter = painterResource(R.drawable.character),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                        Spacer(Modifier.height(5.dp))
                        Text("Character",style = TextStyle(
                            fontSize = 20.sp
                        ))
                        Text("Personal details", style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        ))
                    }
                }

                Spacer(modifier = Modifier.width(13.dp))

                Card (
                    modifier = Modifier
                        .height(170.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(painter = painterResource(R.drawable.bankcard),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                        Spacer(Modifier.height(5.dp))
                        Text("Bank Card",style = TextStyle(
                            fontSize = 20.sp
                        ))
                        Text("Payment details", style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        ))
                    }
                }
            }

            Spacer(Modifier.height(13.dp))

            //Row 3
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Card (
                    modifier = Modifier
                        .height(172.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(painter = painterResource(R.drawable.password),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                        Spacer(Modifier.height(5.dp))
                        Text("Password",style = TextStyle(
                            fontSize = 20.sp
                        ))
                        Text("Login info", style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        ))
                    }
                }

                Spacer(modifier = Modifier.width(13.dp))

                Card (
                    modifier = Modifier
                        .height(170.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(painter = painterResource(R.drawable.logistics),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                        Spacer(Modifier.height(5.dp))
                        Text("Logistics",style = TextStyle(
                            fontSize = 20.sp
                        ))
                        Text("Shipment tracking", style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        ))
                    }
                }
            }

            Spacer(Modifier.height(13.dp))

            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(
                    Color.White
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Image(painter = painterResource(R.drawable.setting),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp))

                    Column{
                        Text("Settings", style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        ))
                        Text("Manage your preferences", style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        ))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard(){
    CardBody()
}