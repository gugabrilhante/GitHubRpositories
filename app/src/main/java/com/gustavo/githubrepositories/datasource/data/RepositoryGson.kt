package com.gustavo.githubrepositories.datasource.data

import com.google.gson.annotations.SerializedName


data class RepositoryGson (

	@SerializedName("url") val url : String,
	@SerializedName("forks_url") val forks_url : String,
	@SerializedName("commits_url") val commits_url : String,
	@SerializedName("id") val id : String,
	@SerializedName("node_id") val node_id : String,
	@SerializedName("git_pull_url") val git_pull_url : String,
	@SerializedName("git_push_url") val git_push_url : String,
	@SerializedName("html_url") val html_url : String,
	@SerializedName("public") val public : Boolean,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("updated_at") val updated_at : String,
	@SerializedName("description") val description : String,
	@SerializedName("comments") val comments : Int,
	@SerializedName("user") val user : String,
	@SerializedName("comments_url") val comments_url : String,
	@SerializedName("ownerGson") val ownerGson : OwnerGson,
	@SerializedName("truncated") val truncated : Boolean
)