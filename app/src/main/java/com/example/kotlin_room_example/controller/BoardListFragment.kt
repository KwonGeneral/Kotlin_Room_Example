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
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.kotlin_room_example.R
import com.example.kotlin_room_example.adapter.ListAdapter
import com.example.kotlin_room_example.adapter.ListItem
import com.example.kotlin_room_example.model.BoardData
import com.example.kotlin_room_example.model.BoardDataBase


class BoardListFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    var items = arrayListOf<ListItem>()
    var db: BoardDataBase? = null
    var board_list = mutableListOf<BoardData>()

    companion object{
        fun newInstance() : BoardListFragment {
            return BoardListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_board_list, container, false)
//        Log.d("TEST","BoardListFragment - onCreateView")
        val board_add_btn = view.findViewById<Button>(R.id.board_add_btn)
        val blank_text = view.findViewById<TextView>(R.id.blank_text)
        val board_reset_btn = view.findViewById<Button>(R.id.board_reset_btn)

        //초기화
        db = BoardDataBase.getInstance(requireContext())

        //이전에 저장한 내용 모두 불러와서 추가하기
        val savedContacts = db!!.boardInterface().boardGet()
        if(savedContacts.isNotEmpty()){
            blank_text.visibility = View.GONE
            board_list.addAll(savedContacts)
            for(kk in board_list) {
                if(kk.id != null && kk.title != null && kk.content != null) {
                    items.add(
                        ListItem(kk.id!!, kk.title, kk.content)
                    )
                }

                Log.d("TEST", "Board_List ID : ${kk.id}")
                Log.d("TEST", "Board_List Title : ${kk.title}")
                Log.d("TEST", "Board_List Content : ${kk.content}")
            }
            recyclerView = view.findViewById(R.id.board_list_recycle) as RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = ListAdapter(requireContext(), items)
        } else {
            blank_text.visibility = View.VISIBLE
        }

        board_reset_btn.setOnClickListener {
            db = BoardDataBase.getInstance(requireContext())
            db!!.boardInterface().boardClear()
            items.clear()
            board_list.clear()

            recyclerView.adapter!!.notifyDataSetChanged()

            blank_text.visibility = View.VISIBLE
        }

        board_add_btn.setOnClickListener {
            (activity as MainActivity).changeFragment(3)
        }

        Log.d("TEST", "게시판 목록 DB : ${db!!.boardInterface().boardGet()}")

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("TEST","BoardListFragment - onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        Log.d("TEST","BoardListFragment - onAttach")
    }

    override fun onPause() {
        super.onPause()
//        Log.d("TEST", "BoardListFragment - onPause")
    }

    override fun onResume() {
        super.onResume()
//        Log.d("TEST", "BoardListFragment - onResume")
    }

    override fun onStop() {
        super.onStop()
//        Log.d("TEST", "BoardListFragment - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.d("TEST", "BoardListFragment - onDestroy")
    }
}