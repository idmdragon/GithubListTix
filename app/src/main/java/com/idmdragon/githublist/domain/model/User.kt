package com.idmdragon.githublist.domain.model

data class User(
    val avatarUrl: String,
    val userId: Int,
    val username: String,
    val repoUrl: String,
    val email: String?,
    val createdDate: String?
)