package com.example.stree

data class Example(
    val limit: Number,
    val products: Array<Products>,
    val skip: Number,
    val total: Number
)

data class Products(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Number,
    val id: Number,
    val images: Array<String>,
    val price: Number,
    val rating: Number,
    val stock: Number,
    val thumbnail: String,
    val title: String
)