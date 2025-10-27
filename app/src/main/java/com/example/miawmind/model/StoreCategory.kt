package com.example.miawmind.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreCategory(
    val id: Int,
    val name: String
): Parcelable
