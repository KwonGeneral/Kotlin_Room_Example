package com.example.kotlin_room_example

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BoardData::class], version = 1)
abstract class BoardDataBase : RoomDatabase() {
    abstract fun boardInterface(): BoardInterface
}

