package com.idmdragon.githublist.mapper

import com.idmdragon.githublist.data.response.UserResponse
import com.idmdragon.githublist.domain.model.User

fun UserResponse.toModel(): User =
    User(
        avatarUrl = avatar_url,
        userId = id,
        username = login,
        repoUrl = repos_url,
        email = email,
        createdDate = created_at
    )

fun List<UserResponse>.toModels(): List<User> =
    this.map {
        it.toModel()
    }