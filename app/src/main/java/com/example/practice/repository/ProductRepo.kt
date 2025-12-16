package com.example.practice.repository

import com.example.practice.model.ProductModel
import com.google.firebase.auth.FirebaseUser

interface ProductRepo {
    fun addProduct(model: ProductModel, callback: (Boolean, String) -> Unit
    )

    fun editProduct(model: ProductModel, callback: (Boolean, String) -> Unit
    )

    fun deleteProduct(productId: String, callback: (Boolean, String) -> Unit)

    fun getProductById(productId: String,
                       callback: (Boolean, String, ProductModel?) -> Unit)

    fun getAllProduct(callback: (Boolean, String, List<ProductModel>?) -> Unit)

    fun getProductByCategory(categoryId:String,callback: (Boolean, String, List<ProductModel>?) -> Unit)
}