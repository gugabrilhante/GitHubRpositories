package com.gustavo.githubrepositories.entity

import java.io.Serializable

data class Owner(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val name: String?
):Serializable