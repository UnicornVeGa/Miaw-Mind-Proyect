package com.example.miawmind.ui.fragments.tutorials

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentGeneralGameGuideBinding


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView

class GeneralGameGuideFragment : DialogFragment() {

    private var _binding: FragmentGeneralGameGuideBinding? = null
    private val binding get() = _binding!!

    private var currentPage = 0
    private val totalPages = 5

    private val descriptions = listOf(
        getString(R.string.step1),
        getString(R.string.step2),
        getString(R.string.step3),
        getString(R.string.step4),
        getString(R.string.step5)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralGameGuideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDots()
        updatePage()

        binding.btnPrev.setOnClickListener {
            if (currentPage > 0) {
                currentPage--
                updatePage()
            }
        }

        binding.btnNext.setOnClickListener {
            if (currentPage < totalPages - 1) {
                currentPage++
                updatePage()
            }
        }

        binding.btnDone.setOnClickListener {
            dismiss()
        }
    }

    private fun setupDots() {
        binding.dotsContainer.removeAllViews()
        for (i in 0 until totalPages) {
            val dot = ImageView(requireContext()).apply {
                setImageResource(R.drawable.dot_inactive)
                val params = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                params.marginEnd = 8
                layoutParams = params
            }
            binding.dotsContainer.addView(dot)
        }
    }

    private fun updatePage() {
        binding.tvDescription.text = descriptions[currentPage]
        binding.ivGuideImage.setImageResource(R.drawable.ic_missing_image)

        for (i in 0 until totalPages) {
            val dot = binding.dotsContainer.getChildAt(i) as ImageView
            if (i == currentPage) {
                dot.setImageResource(R.drawable.dot_active)
            } else {
                dot.setImageResource(R.drawable.dot_inactive)
            }
        }

        binding.btnDone.isEnabled = currentPage == (totalPages - 1)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setBackgroundDrawable(ColorDrawable(Color.GRAY))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
