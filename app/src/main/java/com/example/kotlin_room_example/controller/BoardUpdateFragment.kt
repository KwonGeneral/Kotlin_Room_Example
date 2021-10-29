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


class BoardUpdateFragment : Fragment() {
    // 값 전달 변수
    var share_id = ""
    var share_title = ""
    var share_content = ""

    var db: BoardDataBase? = null

    companion object{
        fun newInstance() : BoardUpdateFragment {
            return BoardUpdateFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_board_update, container, false)
//        Log.d("TEST","BoardUpdateFragment - onCreateView")

        val board_update_title = view.findViewById<EditText>(R.id.board_update_title)
        val board_update_content = view.findViewById<EditText>(R.id.board_update_content)
        val board_update_submit_btn = view.findViewById<Button>(R.id.board_update_submit_btn)

        //초기화
        db = BoardDataBase.getInstance(requireContext())

        val bundle_arguments = arguments
        share_id = bundle_arguments?.getString("id").toString()
        share_title = bundle_arguments?.getString("title").toString()
        share_content = bundle_arguments?.getString("content").toString()

        board_update_title.setText(share_title)
        board_update_content.setText(share_content)

        board_update_submit_btn.setOnClickListener {
            val temp_title = board_update_title.text.toString()
            val temp_content = board_update_content.text.toString()
            db!!.boardInterface().boardUpdate(BoardData(share_id.toInt(), temp_title, temp_content))
            (activity as MainActivity).changeFragment(0)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("TEST","BoardUpdateFragment - onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        Log.d("TEST","BoardUpdateFragment - onAttach")
    }

    override fun onPause() {
        super.onPause()
//        Log.d("TEST", "BoardUpdateFragment - onPause")
    }

    override fun onResume() {
        super.onResume()
//        Log.d("TEST", "BoardUpdateFragment - onResume")
    }

    override fun onStop() {
        super.onStop()
//        Log.d("TEST", "BoardUpdateFragment - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.d("TEST", "BoardUpdateFragment - onDestroy")
    }
}