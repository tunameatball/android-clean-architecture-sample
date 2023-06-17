package com.kkh.clean_architecture_sample.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.kkh.clean_architecture_sample.databinding.ItemLocationBinding
import com.kkh.domain.model.Location

class LocationViewHolder(val binding: ItemLocationBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Location) {
        binding.tvTitle.text = item.title ?: "TITLE"
    }
}