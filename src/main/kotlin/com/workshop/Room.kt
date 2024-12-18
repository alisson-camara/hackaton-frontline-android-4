package com.workshop

import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val name: String?,
    val moderator: String?,
    val currentTask: String? = null,
    val players: List<Player>? = null
)

@Serializable
data class Player(
    val name: String?,
    val point: String?
)