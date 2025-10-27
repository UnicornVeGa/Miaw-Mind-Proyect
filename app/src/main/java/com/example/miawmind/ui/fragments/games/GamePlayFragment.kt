package com.example.miawmind.ui.fragments.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentGamePlayBinding

class GamePlayFragment : Fragment() {

    private var _binding: FragmentGamePlayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGamePlayBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPauseGame.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.game_pause),Toast.LENGTH_SHORT).show()
        }

        binding.btnGoToEndGame.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.gamePlayFragment, true)
                .build()

            findNavController().navigate(GamePlayFragmentDirections.actionGamePlayFragmentToEndGameFragment(),navOptions)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}