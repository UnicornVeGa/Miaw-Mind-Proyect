package com.example.miawmind.ui.fragments.settings

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentSettingsBinding
import com.example.miawmind.utils.Constants
import androidx.core.content.edit

class SettingsFragment : DialogFragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private lateinit var sp: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sp = requireContext().getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE)

        val isMusicEnabled = sp.getBoolean(Constants.KEY_MUSIC, true)
        val isSoundEnabled = sp.getBoolean(Constants.KEY_SOUND, true)

        binding.switchMusic.isChecked = isMusicEnabled
        binding.switchSound.isChecked = isSoundEnabled

        binding.switchMusic.setOnCheckedChangeListener { _, isChecked ->
            sp.edit {
                putBoolean(Constants.KEY_MUSIC, isChecked)
            }
        }

        binding.switchSound.setOnCheckedChangeListener { _, isChecked ->
            sp.edit {
                putBoolean(Constants.KEY_SOUND, isChecked)
            }
        }


        binding.frameBackground.setOnClickListener {
            dialog?.dismiss()
        }

        binding.mainCard.setOnClickListener {

        }

        binding.btnGuide.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToGeneralGameGuideFragment())
        }


    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
