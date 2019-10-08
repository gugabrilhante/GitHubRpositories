package com.gustavo.githubrepositories.entity

import com.google.gson.annotations.SerializedName

class Repository (
    @SerializedName("description") val description : String,
    @SerializedName("user") val user : String

    )