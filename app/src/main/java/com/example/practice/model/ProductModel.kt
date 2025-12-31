package com.example.practice.model

data class ProductModel(
    var productId : String = "",
    val productName : String = "",
    val price : String = "",
    val description : String = "",
    val categoryId : String = "",
    var image : String = ""
) {
    fun toMap() : Map<String, Any?> {
        return mapOf(
            "productId" to productId,
            "productName" to productName,
            "price" to price,
            "description" to description,
            "categoryId" to categoryId
        )
    }
}