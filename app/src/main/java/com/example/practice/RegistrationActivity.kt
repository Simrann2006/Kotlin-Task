package com.example.practice

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
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
import androidx.compose.ui.unit.toSize
import com.example.practice.model.UserModel
import com.example.practice.repository.UserRepoImpl
import com.example.practice.ui.theme.Blue
import com.example.practice.ui.theme.Light_grey
import com.example.practice.ui.theme.Light_grey1
import com.example.practice.ui.theme.PracticeTheme
import com.example.practice.ui.theme.White
import com.example.practice.viewmodel.UserViewModel
import java.util.Calendar

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterBody()
        }
    }
}

//file and activity name upper camel case
// class variable name lower camel case
@Composable
fun RegisterBody(){

    val userViewModel = remember { UserViewModel(UserRepoImpl()) }

    var email by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }

    var terms by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val sharedPreference = context.getSharedPreferences("User",
        Context.MODE_PRIVATE)

    val editor = sharedPreference.edit()

    val activity = context as Activity

    val calendar = Calendar.getInstance()

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    var datepicker = DatePickerDialog(
        context, { _, y, m, d ->
            selectedDate = "$y/${m + 1}/$d"

        }, year, month, day
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("Selected Option") }

    val options = listOf("Option 1","Option 2","Option 3")

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(White)
        ) {
            Spacer(Modifier.height(60.dp))

            Text(
                "Sign Up",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(Modifier.height(25.dp))

            OutlinedTextField(
                value = firstName,

                onValueChange = { data ->
                    firstName = data
                },
                placeholder = {
                    Text("First Name")
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

            OutlinedTextField(
                value = lastName,

                onValueChange = { data ->
                    lastName = data
                },
                placeholder = {
                    Text("Last Name")
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

            OutlinedTextField(
                value = contact,

                onValueChange = { data ->
                    contact = data
                },
                placeholder = {
                    Text("Contact")
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

            OutlinedTextField(
                value = selectedDate,

                onValueChange = {
                    selectedDate = it
                },
                placeholder = {
                    Text("dd/mm/yyyy")
                },
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        datepicker.show()
                    }
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape((15.dp)),
                colors = TextFieldDefaults.colors(
                    disabledIndicatorColor = Color.Transparent,
                    disabledContainerColor = Light_grey1,
                    focusedContainerColor = Light_grey1,
                    unfocusedContainerColor = Light_grey1,
                    focusedIndicatorColor = Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = password,

                onValueChange = { data ->
                    password = data
                },
                visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = selectedOptionText,
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // capture the size of the TextField
                            textFieldSize = coordinates.size.toSize()
                        }
                        .clickable { expanded = true },
                    placeholder = { Text("Select Option") },
                    enabled = false, // prevent manual typing
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null
                        )
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                selectedOptionText = option
                                expanded = false
                            }
                        )
                    }
                }
            }
            
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = terms,
                    onCheckedChange = {
                        terms = it
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Blue,
                        checkmarkColor = White
                    )
                )
                Text("I agree to terms & conditions")
            }

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {
                    if(!terms){
                        Toast.makeText(context,"Please agree to terms & conditions", Toast.LENGTH_SHORT).show()
                    }else{
                        userViewModel.register(email, password) {
                        success, message, userId ->
                            if (success){
                                var model = UserModel(
                                    userId = userId,
                                    email = email,
                                    dob = selectedDate,
                                    firstName = firstName,
                                    contact = contact,
                                    lastName = lastName
                                )
                                userViewModel.addUserToDatabase(userId, model) { success, message ->
                                    if (success) {
                                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                    } else{
                                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                    }
                                    val intent = Intent(context, LoginActivity::class.java)
                                    context.startActivity(intent)
                                    activity.finish()
                                }
                            } else{
                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                            }
                        }
//                        editor.putString("email",email)
//                        editor.putString("password",password)
//                        editor.putString("date",selectedDate)
//
//                        editor.apply()
//                        activity.finish()
//
//                        Toast.makeText(context,"Registration success", Toast.LENGTH_SHORT).show()
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
                Text(
                    "Sign Up", style = TextStyle(
                        fontSize = 16.sp
                    )
                )
            }

            Text(
                buildAnnotatedString {
                    append("Already have an account?")

                    withStyle(style = SpanStyle(color = Blue)) {
                        append(" Sign In")
                    }
                },
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewRegister(){
    RegisterBody()
}