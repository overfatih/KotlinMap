package com.profplay.kotlinmap.adapter

import android.app.ActivityManager.RecentTaskInfo
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.profplay.kotlinmap.databinding.ActivityMainBinding
import com.profplay.kotlinmap.databinding.RecyclerRowBinding
import com.profplay.kotlinmap.model.Place
import com.profplay.kotlinmap.view.MapsActivity

class PlaceAdapter(val placeList : List<Place>) : RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {

    class PlaceHolder(val recyclerViewRowBinding: RecyclerRowBinding) : ViewHolder(recyclerViewRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlaceHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.recyclerViewRowBinding.recyclerViewTextView.text = placeList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,MapsActivity::class.java)
            intent.putExtra("selectedPlace", placeList.get(position))
            intent.putExtra("info","old")
            holder.itemView.context.startActivity(intent)
        }
    }

}