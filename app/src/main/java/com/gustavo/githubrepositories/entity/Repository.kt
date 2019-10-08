package com.gustavo.githubrepositories.entity

import com.google.gson.annotations.SerializedName

class Repository(
    val description: String,
    val user: String,
    val owner: Owner
)