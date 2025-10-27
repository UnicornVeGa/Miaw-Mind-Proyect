package com.example.miawmind.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val categoryId: Int
): Parcelable
