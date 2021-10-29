package com.example.kotlin_room_example

import androidx.room.*

@Dao
interface BoardInterface {
    @Query("SELECT * FROM BoardData")
    fun boardGet() : List<BoardData>

    @Insert
    fun boardInsert(vararg board: BoardData)

    @Update
    fun boardUpdate(vararg board: BoardData)

    @Delete
    fun boardDelete(board: BoardData)
}

