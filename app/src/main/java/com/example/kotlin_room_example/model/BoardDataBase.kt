package com.example.kotlin_room_example.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BoardData::class], version = 4, exportSchema = false)
abstract class BoardDataBase : RoomDatabase() {
    abstract fun boardInterface(): BoardInterface

    companion object {
        private var instance: BoardDataBase? = null

        @Synchronized
        fun getInstance(context: Context): BoardDataBase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    BoardDataBase::class.java,
                    "board_db"
                )
                    .fallbackToDestructiveMigration()  // 스키마(Database) 버전 변경 가능
                    .allowMainThreadQueries()  // Main Thread에서 DB에 IO(Input/Output)를 가능하게 함
                    .build()
            }
            return instance
        }
    }
}

