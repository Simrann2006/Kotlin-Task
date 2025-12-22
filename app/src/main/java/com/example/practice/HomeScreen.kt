package com.example.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.practice.model.ProductModel
import com.example.practice.repository.ProductRepoImpl
import com.example.practice.viewmodel.ProductViewModel

@Composable
fun HomeScreen() {

    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }

    var productName by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val product = productViewModel.products.observeAsState(initial = null)

    LaunchedEffect(product.value) {
        productViewModel.getAllProduct()

        product.value?.let{
            productName = it.productName
            price = it.price
            description = it.description
        }
    }

    var showDialog by remember { mutableStateOf(false) }

    val allProducts = productViewModel.allProducts.observeAsState(initial = emptyList())
    val loading = productViewModel.loading.observeAsState(initial = false)

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        item {
            if (showDialog){
                AlertDialog(
                    onDismissRequest = {
                        showDialog = false
                    },
                    confirmButton = {
                        TextButton(onClick = {
                            var model = ProductModel(
                                product.value!!.productId,
                                productName,
                                price,
                                description,
                                ""
                            )
                            productViewModel.editProduct(model){
                                success, message->
                                if(success){
                                    showDialog = false
                                } else{
                                    // toast message
                                }
                            }
                        }) {
                            Text("Update")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            showDialog = false
                        }) {
                            Text("Cancle")
                        }
                    },
                    title = {
                        Text("Update Product")
                    },
                    text = {
                        Column {
                            Spacer(modifier = Modifier.height(50.dp))
                            OutlinedTextField(value = productName, onValueChange = { productName = it })
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(value = price, onValueChange = { price = it })
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(value = description, onValueChange = { description = it })
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                )
            }
        }
        if(loading.value){
            item {
                CircularProgressIndicator()
            }
        }else{
            items(allProducts.value!!.size){index->
                var data = allProducts.value!![index]
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(data.productName)
                        Text(data.price)
                        Text(data.description)
                        IconButton(onClick = {
                            showDialog = true
                            productViewModel
                                .getProductById(data.productId)
                        }) {
                            Icon(Icons.Default.Edit,contentDescription = null)
                        }
                        IconButton(onClick = {
                            productViewModel.deleteProduct(data.productId){
                                    success,message->
                                if(success){

                                }else{

                                }
                            }
                        }) {
                            Icon(Icons.Default.Delete,contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}