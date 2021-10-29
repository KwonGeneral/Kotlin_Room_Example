package com.example.kotlin_room_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            BoardDataBase::class.java, "board_db"
        )
        .fallbackToDestructiveMigration()  // 스키마(Database) 버전 변경 가능
        .allowMainThreadQueries()  // Main Thread에서 DB에 IO(Input/Output)를 가능하게 함
        .build()

        submit_btn.setOnClickListener {
            val title = edit_title.text.toString()
            val content = edit_content.text.toString()
            if(title == "") {
                return@setOnClickListener
            }
            else if(content == "") {
                return@setOnClickListener
            } else {
                db.boardInterface().boardInsert(BoardData(title = title, content = content))
                get_db_text.text = db.boardInterface().boardGet().toString()
            }
        }
    }
}

