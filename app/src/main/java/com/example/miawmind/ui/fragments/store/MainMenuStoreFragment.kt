package com.example.miawmind.ui.fragments.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentMainMenuStoreBinding
import com.example.miawmind.model.StoreCategory
import com.example.miawmind.model.StoreDataSource
import com.example.miawmind.ui.adapters.ProductsAdapter
import com.example.miawmind.utils.Constants
import com.example.miawmind.utils.GridSpacingItemDecoration
import com.google.android.material.tabs.TabLayout

class MainMenuStoreFragment : Fragment() {
    private var _binding: FragmentMainMenuStoreBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterList: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainMenuStoreBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = StoreDataSource.getProducts(requireContext())
        val categories = listOf(StoreCategory(-1, getString(R.string.all))) + StoreDataSource.getCategories(requireContext())

        adapterList = ProductsAdapter(products) { selectedProduct ->

            findNavController().navigate(
                MainMenuStoreFragmentDirections.actionMainMenuStoreFragmentToPurchaseProductFragment(selectedProduct)
            )
        }

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(requireContext(), Constants.NUMBER_OF_MENU_COLUMNS)

            addItemDecoration(
                GridSpacingItemDecoration(2,20,true)
            )

            adapter = adapterList
        }

        categories.forEach { category ->
            binding.tabLayoutCategories.addTab(
                binding.tabLayoutCategories
                    .newTab()
                    .setText(category.name)
                    .setTag(category.id)
            )
        }

        binding.tabLayoutCategories.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val selectedCategory = tab.tag as Int
                val filteredList = if (selectedCategory == -1) {
                    products
                } else {
                    StoreDataSource.getProductsOfCategory(requireContext(),selectedCategory)
                }
                adapterList.updateData(filteredList)
                binding.rvProducts.smoothScrollToPosition(0)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}