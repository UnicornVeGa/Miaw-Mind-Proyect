package com.example.miawmind.ui.fragments.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentPurchaseProductBinding
import com.example.miawmind.databinding.FragmentStartGameBinding
import com.example.miawmind.ui.fragments.games.StartGameFragmentArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PurchaseProductFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentPurchaseProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPurchaseProductBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: PurchaseProductFragmentArgs by navArgs()
        val product = args.selectedProduct

        binding.apply {
            tvProductName.text = product.name
            tvProductDescription.text = product.description
            tvProductPrice.text = getString(R.string.product_price, product.price)
        }

        binding.btnAdd.setOnClickListener {
            val count = binding.tvProductCount.text.toString().toInt()
            if (count < 10) {
                binding.tvProductCount.text = (count + 1).toString()
                binding.tvProductPrice.text = getString(R.string.product_price,(count + 1) * product.price)
            }
        }

        binding.btnSubtract.setOnClickListener {
            val count = binding.tvProductCount.text.toString().toInt()
            if (count > 1) {
                binding.tvProductCount.text = (count - 1).toString()
                binding.tvProductPrice.text = getString(R.string.product_price,(count - 1) * product.price)
            }
        }

        binding.btnPurchase.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle(getString(R.string.confirmation_title))
            builder.setMessage(getString(R.string.confirmation_message))

            builder.setPositiveButton(getString(R.string.accept)) { dialog, which ->
                Toast.makeText(requireContext(),
                    getString(R.string.checkout_message), Toast.LENGTH_SHORT).show()
                findNavController().navigate(PurchaseProductFragmentDirections.actionGlobalToMainMenuStoreFragment())
            }

            builder.setNegativeButton(getString(R.string.cancel)) { dialog, which ->
            }

            val dialog = builder.create()
            dialog.show()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}