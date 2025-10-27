package com.example.miawmind.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.databinding.ItemGameCardBinding
import com.example.miawmind.databinding.ItemInventoryCardBinding
import com.example.miawmind.model.InventoryItem

class InventoryItemAdapter (
    private var items: List<InventoryItem>
): RecyclerView.Adapter<InventoryItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): InventoryItemViewHolder
    {
        val binding = ItemInventoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InventoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: InventoryItemViewHolder,
        position: Int)
    {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<InventoryItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}
