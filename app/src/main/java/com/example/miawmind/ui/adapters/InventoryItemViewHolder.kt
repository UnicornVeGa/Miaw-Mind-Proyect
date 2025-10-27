package com.example.miawmind.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.databinding.ItemInventoryCardBinding
import com.example.miawmind.model.InventoryItem

class InventoryItemViewHolder (
    private val binding: ItemInventoryCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(inventoryItem: InventoryItem) {
        binding.tvItemName.text = inventoryItem.name
        binding.tvItemCount.text = inventoryItem.count.toString()
    }
}