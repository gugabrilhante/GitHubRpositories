package com.gustavo.githubrepositories.entity

import java.io.Serializable

data class Repository(
    val name: String,
    val description: String?,
    val owner: Owner,
    val isFork: Boolean
) : Serializable