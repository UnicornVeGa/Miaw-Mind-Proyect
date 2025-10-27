package com.example.miawmind.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val name: String,
    val ability: String,
    val description: String
): Parcelable
