package com.workshop.db.entitites

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object RoomTable : Table() {
    val id = uuid("id").clientDefault { UUID.randomUUID() }
    val name = varchar("name", 50)
    val currentTask = varchar("current_task", 50)
    val moderator = varchar("moderator", 50)
    override val primaryKey = PrimaryKey(id)
}