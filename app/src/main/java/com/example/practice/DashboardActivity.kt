package com.example.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.Blue
import com.example.practice.ui.theme.PracticeTheme
import com.example.practice.ui.theme.White

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashBoardBody()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardBody(){

    val context = LocalContext.current
    val activity = context as Activity

    data class NavItem(val label : String, val icon : Int)

    var selectedIndex by remember { mutableStateOf(0) }

    val listItem = listOf(
        NavItem(label = "Home", icon = R.drawable.baseline_home_24),
        NavItem(label = "Search", icon = R.drawable.baseline_search_24),
        NavItem(label = "Notification", icon = R.drawable.baseline_notifications_none_24),
        NavItem(label = "Profile", icon = R.drawable.baseline_person_24)
    )

//    val email = activity.intent.getStringExtra("email")
//    val password = activity.intent.getStringExtra("password")

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val intent = Intent(
                    context,
                    ProductActivity::class.java)
                context.startActivity(intent)
            }, containerColor = Blue) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        containerColor = Blue,
        topBar = {
            // CenterTopBar for center alignment and large app top bar
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = White,
                    actionIconContentColor = White,
                    containerColor = Blue,
                    navigationIconContentColor = White
                ),
                title = {
                    Text("Ecommerce")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(R.drawable.baseline_menu_24),
                            contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(R.drawable.baseline_chat_bubble_24),
                            contentDescription = null)
                    }
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(R.drawable.baseline_notifications_none_24),
                            contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                listItem.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(painter = painterResource(item.icon),contentDescription = null)
                        },
                        label = {Text(item.label)},
                        onClick = {
                            selectedIndex = index
                        },
                        selected = selectedIndex == index
                    )
                }
            }
        }
    ){ padding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//        ){
//            Text("Email: $email")
//            Text("Password: $password")
//        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when(selectedIndex){
                0 -> HomeScreen()
                1 -> SearchScreen()
                2 -> NotificationScreen()
                3 -> ProfileScreen()
                else -> HomeScreen()
            }
        }
    }
}

@Preview
@Composable
fun PreviewDashboard(){
    DashBoardBody()
}