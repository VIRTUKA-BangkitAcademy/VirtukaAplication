package com.example.firtukaapps.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firtukaapps.R

class ListGlassesAdapter(private val listGlasses: ArrayList<Glasses>) : RecyclerView.Adapter<ListGlassesAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.text_name)
        val tvType: TextView = itemView.findViewById(R.id.text_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listGlasses.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, type, photo) = listGlasses[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvType.text = type
    }
}