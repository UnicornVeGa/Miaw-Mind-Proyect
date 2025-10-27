package com.example.miawmind.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentHomeBinding
import com.example.miawmind.model.InventoryDataSource
import com.example.miawmind.ui.adapters.InventoryItemAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterItems: InventoryItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressHappiness.setProgress(80, true)
        binding.progressEnergy.setProgress(40, true)
        binding.progressHealth.setProgress(90, true)

        recyclerView = binding.rvCarousel

        val initialItems = InventoryDataSource.getItemsOfCategory(requireContext(),1)
        adapterItems = InventoryItemAdapter(initialItems)

        binding.rvCarousel.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterItems
        }

        setupCategoryButtons()
    }

    private fun setupCategoryButtons() {
        binding.btnFood.setOnClickListener {
            updateInventoryList(1)
            binding.rvCarousel.smoothScrollToPosition(0)
        }
        binding.btnToys.setOnClickListener {
            updateInventoryList(2)
            binding.rvCarousel.smoothScrollToPosition(0)
        }
        binding.btnHealth.setOnClickListener {
            updateInventoryList(3)
            binding.rvCarousel.smoothScrollToPosition(0)
        }
        binding.btnHome.setOnClickListener {
            updateInventoryList(4)
            binding.rvCarousel.smoothScrollToPosition(0)
        }
    }

    private fun highlightSelectedCategory(selectedId: Int) {
        val buttons = listOf(binding.btnFood, binding.btnToys, binding.btnHealth, binding.btnHome)
        buttons.forEach { it.setBackgroundResource(R.drawable.rounded_background) }
        val selectedButton = buttons.firstOrNull { it.id == selectedId }
        selectedButton?.setBackgroundResource(R.drawable.inventory_rounded_button_background)
    }


    private fun updateInventoryList(categoryId: Int) {
        val filteredItems = InventoryDataSource.getItemsOfCategory(requireContext(),categoryId)
        adapterItems.updateData(filteredItems)

        when (categoryId) {
            1 -> highlightSelectedCategory(binding.btnFood.id)
            2 -> highlightSelectedCategory(binding.btnToys.id)
            3 -> highlightSelectedCategory(binding.btnHealth.id)
            4 -> highlightSelectedCategory(binding.btnHome.id)
        }
    }
}