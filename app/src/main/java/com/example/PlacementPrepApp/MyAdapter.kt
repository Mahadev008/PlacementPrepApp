package com.example.PlacementPrepApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (val usersList: ArrayList<Users>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvName: TextView =itemView.findViewById(R.id.tv_name)
        val tvDesignation: TextView =itemView.findViewById(R.id.tv_designation)
        val tvEmail: TextView =itemView.findViewById(R.id.tv_email)
        val tvComments: TextView =itemView.findViewById(R.id.tv_comments)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return  MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.tvName.text = usersList[position].empname
        holder.tvDesignation.text = usersList[position].empDesignation
        holder.tvEmail.text = usersList[position].empmail
        holder.tvComments.text = usersList[position].empComments
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}




