package com.idmdragon.githublist.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @field:SerializedName("avatar_url")
    val avatar_url: String,
    @field:SerializedName("id")
    val userId: Int,
    @field:SerializedName("login")
    val username: String,
)