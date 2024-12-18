package com.workshop.db.entitites

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object PlayerTable: Table() {
    val id = uuid("id").clientDefault { UUID.randomUUID() }
    val name = varchar("name", 50)
    val point = varchar("current_task", 50)
    val room = reference("room_id", RoomTable.id)
    override val primaryKey = PrimaryKey(RoomTable.id)
}