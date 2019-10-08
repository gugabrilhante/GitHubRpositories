package com.gustavo.githubrepositories.entity

import com.google.gson.annotations.SerializedName

data class Owner (
    val login : String,
    val id : Int,
    val avatar_url : String
    )