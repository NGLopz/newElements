package com.example.bottomexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomexample.databinding.ItemBinding

class CustomAdapter( private val heroList: ArrayList<Hero>,
                     private val listener: (Hero, Int) -> Unit
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(heroList[position])
        holder.itemView.setOnClickListener { listener(heroList[position], position) }

    }


    override fun getItemCount(): Int = heroList.size



    class ViewHolder(private var itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(hero: Hero) {
            itemBinding.image.loadImage(hero.image)
            itemBinding.name.text = hero.name
        }
    }
}