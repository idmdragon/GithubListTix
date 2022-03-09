package com.idmdragon.githublist.data.response


data class UserResponse(
    val avatar_url: String,
    val id: Int,
    val login: String,
    val repos_url: String,
    val email: String?,
    val created_at: String?
)