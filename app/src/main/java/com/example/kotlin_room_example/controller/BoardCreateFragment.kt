package com.example.kotlin_room_example.controller

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.kotlin_room_example.R
import com.example.kotlin_room_example.model.BoardData
import com.example.kotlin_room_example.model.BoardDataBase


class BoardCreateFragment : Fragment() {
    var db: BoardDataBase? = null

    companion object{
        fun newInstance() : BoardCreateFragment {
            return BoardCreateFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_board_create, container, false)
//        Log.d("TEST","BoardCreateFragment - onCreateView")

        val board_create_submit_btn = view.findViewById<Button>(R.id.board_create_submit_btn)
        val board_create_title = view.findViewById<EditText>(R.id.board_create_title)
        val board_create_content = view.findViewById<EditText>(R.id.board_create_content)

        // 초기화
        db = BoardDataBase.getInstance(requireContext())

        board_create_submit_btn.setOnClickListener {
            val temp_title = board_create_title.text.toString()
            val temp_content = board_create_content.text.toString()
            if(temp_title != "" && temp_content != "") {
                db!!.boardInterface().boardInsert(BoardData(null, temp_title, temp_content))
                (activity as MainActivity).changeFragment(0)
            }else {
                return@setOnClickListener
            }
        }


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("TEST","BoardCreateFragment - onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        Log.d("TEST","BoardCreateFragment - onAttach")
    }

    override fun onPause() {
        super.onPause()
//        Log.d("TEST", "BoardCreateFragment - onPause")
    }

    override fun onResume() {
        super.onResume()
//        Log.d("TEST", "BoardCreateFragment - onResume")
    }

    override fun onStop() {
        super.onStop()
//        Log.d("TEST", "BoardCreateFragment - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.d("TEST", "BoardCreateFragment - onDestroy")
    }
}