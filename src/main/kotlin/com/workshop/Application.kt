package com.workshop

import com.workshop.model.FakeTaskRepository
import com.workshop.model.PostgresTaskRepository
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    // testing commit
    //val repository = PostgresTaskRepository()
    val taskRepository = FakeTaskRepository()
    val roomRepository = FakeRoomRepository()
    configureSerialization(taskRepository, roomRepository)
    configureDatabase()
    configureRouting()
}
