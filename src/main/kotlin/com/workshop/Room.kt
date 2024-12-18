package com.workshop

import com.workshop.model.Task
import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val name: String?,
    val moderator: String?,
    val currentTask: Task? = null,
    val players: List<Player>? = null
)

@Serializable
data class Player(
    val name: String?,
    val point: String?
)