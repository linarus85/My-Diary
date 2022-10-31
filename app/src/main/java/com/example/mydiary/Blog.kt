package com.example.mydiary

import java.io.Serializable

data class Blog (
    val imageId: Int,
    val title: String,
    val description: String = "",
):Serializable