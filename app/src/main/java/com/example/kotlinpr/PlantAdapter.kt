package com.example.kotlinpr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpr.databinding.ItemPlantBinding
import java.util.*

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantHolder>() {

    private val plantList = ArrayList<Plant>()

    class PlantHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemPlantBinding.bind(item)
        fun bind(plant: Plant) = with(binding) {
            im.setImageResource(plant.imageId)
            tvTitle.text = plant.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int = plantList.size

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }

}