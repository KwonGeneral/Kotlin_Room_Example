package com.example.kotlin_room_example.controller

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.kotlin_room_example.R
import com.example.kotlin_room_example.adapter.ListItem
import com.example.kotlin_room_example.model.BoardData
import com.example.kotlin_room_example.model.BoardDataBase


class BoardDetailFragment : Fragment() {
    // 값 전달 변수
    var share_id = ""
    var share_title = ""
    var share_content = ""

    var db: BoardDataBase? = null

    companion object{
        fun newInstance() : BoardDetailFragment {
            return BoardDetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_board_detail, container, false)
//        Log.d("TEST","BoardDetailFragment - onCreateView")

        val board_detail_title = view.findViewById<TextView>(R.id.board_detail_title)
        val board_detail_content = view.findViewById<TextView>(R.id.board_detail_content)
        val board_detail_update_btn = view.findViewById<Button>(R.id.board_detail_update_btn)
        val board_detail_check_btn = view.findViewById<Button>(R.id.board_detail_check_btn)
        val board_detail_delete_btn = view.findViewById<Button>(R.id.board_detail_delete_btn)

        // 초기화
        db = BoardDataBase.getInstance(requireContext())

        val bundle_arguments = arguments
        share_id = bundle_arguments?.getString("id").toString()
        share_title = bundle_arguments?.getString("title").toString()
        share_content = bundle_arguments?.getString("content").toString()

        board_detail_title.text = share_title
        board_detail_content.text = share_content

        board_detail_update_btn.setOnClickListener {
            (activity as MainActivity).changeFragment(2, share_id.toInt(), share_title, share_content)
        }

        board_detail_check_btn.setOnClickListener {
            (activity as MainActivity).changeFragment(0)
        }

        board_detail_delete_btn.setOnClickListener {
            db!!.boardInterface().boardDelete(BoardData(share_id.toInt(), share_title, share_content))
            (activity as MainActivity).changeFragment(0)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("TEST","BoardDetailFragment - onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        Log.d("TEST","BoardDetailFragment - onAttach")
    }

    override fun onPause() {
        super.onPause()
//        Log.d("TEST", "BoardDetailFragment - onPause")
    }

    override fun onResume() {
        super.onResume()
//        Log.d("TEST", "BoardDetailFragment - onResume")
    }

    override fun onStop() {
        super.onStop()
//        Log.d("TEST", "BoardDetailFragment - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.d("TEST", "BoardDetailFragment - onDestroy")
    }
}