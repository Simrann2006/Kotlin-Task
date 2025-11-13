package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileBody()
        }
    }
}

@Composable
fun ProfileBody(){
    Scaffold { padding ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            //Username
            Row (
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,

            ){
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                    null,
                )
                Text("_simrann13", style = TextStyle(
                   fontSize = 20.sp,
                   fontWeight = FontWeight.Bold
                ))
                Icon(
                    painter = painterResource(R.drawable.baseline_more_horiz_24),
                    null,
                )
            }
            //Profile picture
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = painterResource(R.drawable.me),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.LightGray, CircleShape)
                )
                //Posts
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text("0",style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ))
                    Text("Posts", style = TextStyle(
                        fontSize = 14.sp
                    ))
                }
                //Followers
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text("138",style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ))
                    Text("Followers", style = TextStyle(
                        fontSize = 14.sp
                    ))
                }
                //Following
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text("140",style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ))
                    Text("Following", style = TextStyle(
                        fontSize = 14.sp
                    ))
                }
            }
            //Name and Bio
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ){
                Text("Simran", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                ))
                Text("AI Student",style = TextStyle(
                    fontSize = 14.sp
                ))
                Text("Exploring the world of technology and code",style = TextStyle(
                    fontSize = 14.sp
                ))
                Text("Always curious, always learning",style = TextStyle(
                    fontSize = 14.sp
                ))
                Text("www.facebook.com/simrann13",style = TextStyle(
                    fontSize = 14.sp,
                    color = colorResource(R.color.link)
                ))
            }

            Spacer(modifier = Modifier.height(16.dp))

            //Buttons
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = {
                        //action to trigger
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_blue),
                    ),
                    shape = RoundedCornerShape(8.dp),
//                    border = BorderStroke(2.dp, Color.Red),
                ) {
                    Text("Follow",style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    ))
                }
                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_grey),
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Message",style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ))
                }
            }

            //for outline button all same but instead of Button - OutlineButton

            //Highlights
            Row (
                modifier = Modifier
                    .fillMaxWidth().padding(vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Column(

                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(R.drawable.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.LightGray, CircleShape)
                )
                Text("Story 1")
            }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.image1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(65.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.LightGray, CircleShape)
                    )
                    Text("Story 2")
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.image2),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(65.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.LightGray, CircleShape)
                    )
                    Text("Story 3")
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(65.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.LightGray, CircleShape)
                    )
                    Text("Story 4")
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.image1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(65.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.LightGray, CircleShape)
                    )
                    Text("Story 5")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfile(){
    ProfileBody()
}