package com.example.miawmind.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.R
import com.example.miawmind.databinding.ProductElementBinding
import com.example.miawmind.model.Product

class ProductViewHolder (
    private val binding: ProductElementBinding,
    private val onProductClick: (Product) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    private var currentProduct: Product? =null

    init {
        binding.root.setOnClickListener {
            currentProduct?.let(onProductClick)
        }
    }

    fun bind(product: Product) {
        currentProduct = product
        binding.tvProductName.text = product.name
        binding.tvProductPrice.text = binding.root.context.getString(R.string.product_price, product.price)
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onProductClick: (Product) -> Unit
        ): ProductViewHolder {
            val binding = ProductElementBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ProductViewHolder(binding, onProductClick)
        }
    }
}