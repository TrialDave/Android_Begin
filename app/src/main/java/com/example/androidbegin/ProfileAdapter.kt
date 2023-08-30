package com.example.androidbegin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(private val itemList: List<Profile>) :
    RecyclerView.Adapter<ProfileAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val departmentTextView: TextView = itemView.findViewById(R.id.textViewDepartment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_profile_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.imageView.setImageResource(currentItem.imageId)
        holder.nameTextView.text = currentItem.name
        holder.departmentTextView.text = currentItem.department
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}