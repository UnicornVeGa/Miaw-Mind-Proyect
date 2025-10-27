package com.example.miawmind.model

data class InventoryItem(
    val id: Int,
    val name: String,
    val count: Int,
    val rewardPoints: Int,
    val categoryId: Int
)
