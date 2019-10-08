package com.gustavo.githubrepositories.entity

import com.google.gson.annotations.SerializedName

class Repository(
    val name: String,
    val description: String?,
    val owner: Owner,
    val isFork:Boolean
)