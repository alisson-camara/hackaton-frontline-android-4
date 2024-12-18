package com.workshop.db.entitites

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object TaskTable : Table() {
    val id = uuid("id").clientDefault { UUID.randomUUID() }
    val name = varchar("name", 50)
    val description = varchar("description", 50)
    val priority = varchar("priority", 50)
    override val primaryKey = PrimaryKey(id)
}