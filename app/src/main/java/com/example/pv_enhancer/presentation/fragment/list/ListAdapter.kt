package com.example.pv_enhancer.presentation.fragment.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pv_enhancer.data.openweather.data.model.ResponseOpenweatherDataModel
import com.example.pv_enhancer.data.openweather.data.model.Weather
import com.example.pv_enhancer.databinding.ItemLocationBinding


class ListAdapter(private var dataSet: ResponseOpenweatherDataModel, private val context: Context, private val callback: (item: Weather) -> Unit): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemLocationBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet

        viewHolder.binding.apply {
            itemLocationTextView.text = item.weather.firstOrNull()?.description?: "No Description"
        }
    }


    override fun getItemCount(): Int = 5
}