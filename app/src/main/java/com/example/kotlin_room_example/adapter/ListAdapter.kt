package com.example.kotlin_room_example.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_room_example.R
import com.example.kotlin_room_example.controller.MainActivity
import kotlinx.android.synthetic.main.fragment_board_list_item.view.*


class ListAdapter constructor(var context:Context, var items:ArrayList<ListItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.fragment_board_list_item, parent, false)

        return VH(itemView)
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    @SuppressLint("SetTextI18n", "UseRequireInsteadOfGet")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh: VH =holder as VH

        val item= items[position]

        vh.itemView.list_title.text = item.title

        vh.itemView.list_layout.setOnClickListener {
            (context as MainActivity).changeFragment(1, item.id, item.title, item.content)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class VH constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        init{
        }
    }
}