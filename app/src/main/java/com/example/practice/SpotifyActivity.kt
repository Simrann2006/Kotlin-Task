package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.PracticeTheme

class SpotifyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpotifyBody()
        }
    }
}

@Composable
fun SpotifyBody(){
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF00E7C9),
                            Color(0xFF121212)
                        ),
                        start = Offset(7500f, 0f),
                        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                    )
                )
                .padding(15.dp),
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Good morning", style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                ))
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Icon(painter = painterResource(R.drawable.baseline_notifications_none_24),
                        null,
                        tint = Color.White
                    )
                    Icon(painter = painterResource(R.drawable.baseline_history_24),
                        null,
                        tint = Color.White
                    )
                    Icon(painter = painterResource(R.drawable.outline_settings_24),
                        null,
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            //Row 1
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Card (
                    modifier = Modifier
                        .height(60.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 15.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.dark_grey)
                    )
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        Image(painter = painterResource(R.drawable.lofi),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        Text("lofi beats", style = TextStyle(
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        ))
                        
                    }
                }
                Card (
                    modifier = Modifier
                        .height(60.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 15.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.dark_grey)
                    )
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        Image(
                            painter = painterResource(R.drawable.shaky),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        Text("Shaky", style = TextStyle(
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        ))
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            //Row 2
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Card (
                    modifier = Modifier
                        .height(60.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 15.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.dark_grey)
                    )
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        Image( painter = painterResource(R.drawable.quiet),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        Text("if I could make it go quiet", style = TextStyle(
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        ))
                    }
                }
                Card (
                    modifier = Modifier
                        .height(60.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 15.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.dark_grey)
                    )
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        Image(painter = painterResource(R.drawable.djo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        Text("End Of Beginning", style = TextStyle(
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        ))
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            //Row 3
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Card (
                    modifier = Modifier
                        .height(60.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 15.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.dark_grey)
                    )
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        Image(painter = painterResource(R.drawable.lana),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        Text("Lana Del Rey", style = TextStyle(
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        ))
                    }
                }
                Card (
                    modifier = Modifier
                        .height(60.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 15.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.dark_grey)
                    )
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        Image(painter = painterResource(R.drawable.mix),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        Text("2000s Mix", style = TextStyle(
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        ))
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text("Recently played",style = TextStyle(
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            ))

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(R.drawable.gaga),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Lady Gaga & Bruno Mars\nDie With A Smile",style = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                    ), maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.blue),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Blue by yung kai",style = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp
                    ))
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(R.drawable.nsync),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Bye Bye Bye",style = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp
                    ))
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text("New Releases for you",style = TextStyle(
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            ))

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(R.drawable.local_train),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(175.dp)
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Choo Lo", style = TextStyle(
                        color = Color.White,
                        fontSize = 17.sp)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(R.drawable.kuma),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(175.dp)
                    )

                    Spacer(modifier = Modifier.height(7.dp))
                    Text("Oh Champa", style = TextStyle(
                        color = Color.White,
                        fontSize = 17.sp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSpotify(){
    SpotifyBody()
}