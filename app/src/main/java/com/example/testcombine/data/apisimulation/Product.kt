package com.example.testcombine.data.apisimulation

data class Product(
    val id: Int,
    val name:String,
    val description:String,
    val date: String,
    val category: String,
    val price: Int,
    val eventPrice: Int?,
    val isEvent: Boolean,
    val eventValue: String?,
    val images: List<ProductImage>
)

data class ProductImage(
    val url: String,
)
