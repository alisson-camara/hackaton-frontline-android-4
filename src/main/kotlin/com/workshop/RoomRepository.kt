package com.workshop

interface RoomRepository {
    suspend fun addRoom(room: Room)
    suspend fun getRooms(): List<Room>
    suspend fun joinRoom(roomName: String, playerName: String): Room
    suspend fun getRoom(name: String): Room?
    suspend fun removePlayer(room: String, player: String): Room
}

class FakeRoomRepository : RoomRepository {
    private val rooms = hashMapOf<String, Room>()
    override suspend fun addRoom(room: Room) {
        rooms[room.name!!] = room
    }

    override suspend fun getRooms(): List<Room> = rooms.map { it.value }

    override suspend fun joinRoom(roomName: String, playerName: String): Room {
        val actualRoom = rooms[roomName]
        val players = actualRoom?.players?.toMutableList()
        val newPlayer = Player(name= playerName, point = "?")
        players?.add(newPlayer)
        rooms[actualRoom?.name!!] = actualRoom.copy(players = players)
        return rooms[actualRoom.name] as Room
    }

    override suspend fun getRoom(name: String): Room? {
        val actualRoom = rooms[name]
        return actualRoom
    }

    override suspend fun removePlayer(room: String, player: String): Room {
        var roomObject = getRoom(room)

        val newPlayersList = roomObject?.players?.filter { it.name != player}

        roomObject = roomObject?.copy(players = newPlayersList)

        rooms[room] = roomObject!!

        return roomObject
    }
}