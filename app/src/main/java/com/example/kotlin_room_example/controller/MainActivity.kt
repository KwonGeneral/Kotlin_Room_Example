package com.example.kotlin_room_example.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.kotlin_room_example.R
import com.example.kotlin_room_example.model.BoardData
import com.example.kotlin_room_example.model.BoardDataBase

class MainActivity : AppCompatActivity() {
    private lateinit var board_list_fragment: BoardListFragment
    private lateinit var board_detail_fragment: BoardDetailFragment
    private lateinit var board_update_fragment: BoardUpdateFragment
    private lateinit var board_create_fragment: BoardCreateFragment
    val bundle = Bundle()
    var tag_check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            this,
            BoardDataBase::class.java, "board_db"
        )
            .fallbackToDestructiveMigration()  // 스키마(Database) 버전 변경 가능
            .allowMainThreadQueries()  // Main Thread에서 DB에 IO(Input/Output)를 가능하게 함
            .build()

//        db.boardInterface().boardInsert(BoardData("제목 테스트 3", "내용 테스트 3"))

        Log.d("TEST", "메인 액티비티 DB : ${db.boardInterface().boardGet()}")

        changeFragment(0)

//        submit_btn.setOnClickListener {
//            val title = edit_title.text.toString()
//            val content = edit_content.text.toString()
//            if(title == "") {
//                return@setOnClickListener
//            }
//            else if(content == "") {
//                return@setOnClickListener
//            } else {
//                db.boardInterface().boardInsert(BoardData(title = title, content = content))
//                get_db_text.text = db.boardInterface().boardGet().toString()
//            }
//        }
    }

    fun changeFragment(int: Int, id:Int = 0, title:String = "", content:String = "") {
        bundle.putString("id", id.toString())
        bundle.putString("title", title)
        bundle.putString("content", content)

        if (int == 0) {
            Log.d("TEST", "게시판 목록 프레그먼트")
            board_list_fragment = BoardListFragment.newInstance()
            board_list_fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.main_frag, board_list_fragment).commit()
            tag_check = 0
        } else if (int == 1) {
            Log.d("TEST", "자세히보기 프레그먼트")
            board_detail_fragment = BoardDetailFragment.newInstance()
            board_detail_fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.main_frag, board_detail_fragment).commit()
            tag_check = 1
        } else if (int == 2) {
            Log.d("TEST", "글 수정 프레그먼트")
            board_update_fragment = BoardUpdateFragment.newInstance()
            board_update_fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.main_frag, board_update_fragment).commit()
            tag_check = 2
        } else if (int == 3) {
            Log.d("TEST", "글 쓰기 프레그먼트")
            board_create_fragment = BoardCreateFragment.newInstance()
            board_create_fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.main_frag, board_create_fragment).commit()
            tag_check = 2
        }

    }

    override fun onBackPressed() {
        if(tag_check != 0) {
            changeFragment(0)
        }
    }
}

