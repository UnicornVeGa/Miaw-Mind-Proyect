package com.example.miawmind.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.model.Product

class ProductsAdapter(
    private var products: List<Product>,
    private val onProductClick: (Product) -> Unit
): RecyclerView.Adapter<ProductViewHolder> () {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ProductViewHolder = ProductViewHolder.create(parent,onProductClick)

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int)
    {
        holder.bind(products[position])
    }

    fun updateData(newList: List<Product>) {
        products = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = products.size
}
