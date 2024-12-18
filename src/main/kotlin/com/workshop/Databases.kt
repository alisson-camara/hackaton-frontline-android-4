package com.workshop

import com.workshop.db.entitites.PlayerTable
import com.workshop.db.entitites.RoomTable
import com.workshop.db.entitites.TaskTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    DatabaseFactory.init()
}

object DatabaseFactory {
    fun init() {
        Database.connect(hikari())
        createTables()
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig().apply {
            jdbcUrl = "jdbc:postgresql://localhost:5432/bff-db"
            driverClassName = "org.postgresql.Driver"
            username = "postgres"
            password = "host3636"
            maximumPoolSize = 10
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        }
        return HikariDataSource(config)
    }

    private fun createTables() {
        transaction {
            SchemaUtils.create(RoomTable, TaskTable, PlayerTable)
        }
    }
}