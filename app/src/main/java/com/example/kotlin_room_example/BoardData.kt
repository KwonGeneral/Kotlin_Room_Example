package com.example.kotlin_room_example

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BoardData(

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "content")
    val content: String?
) {
    @PrimaryKey(autoGenerate = true) // autoGenerate = ID가 자동으로 생성 및 카운팅
    var id: Int = 0
}

