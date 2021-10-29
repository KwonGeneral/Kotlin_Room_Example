package com.example.kotlin_room_example.model

import androidx.room.*

@Dao
interface BoardInterface {
    @Query("SELECT * FROM tb_board")
    fun boardGet() : List<BoardData>

    @Query("DELETE FROM tb_board")
    fun boardClear()

//    @Query("DELETE FROM tb_board WHERE id = :id")
//    fun boardDelete(id: Int)

    @Insert
    fun boardInsert(vararg board: BoardData)

    @Update
    fun boardUpdate(vararg board: BoardData)

    @Delete
    fun boardDelete(board: BoardData)
}

