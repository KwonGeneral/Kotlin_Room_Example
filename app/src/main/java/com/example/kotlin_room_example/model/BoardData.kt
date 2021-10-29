package com.example.kotlin_room_example.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_board")
data class BoardData(
    @PrimaryKey(autoGenerate = true) // autoGenerate = ID가 자동으로 생성 및 카운팅
    var id: Int?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "content")
    val content: String?
) {
}

