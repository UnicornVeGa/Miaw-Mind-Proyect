package com.example.miawmind.ui.fragments.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentEndGameBinding

class EndGameFragment : Fragment() {

    private var _binding: FragmentEndGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEndGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRestartGame.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.endGameFragment, true)
                .build()

            findNavController().navigate(EndGameFragmentDirections.actionEndGameFragmentToGamePlayFragment(),navOptions)
        }

        binding.btnExit.setOnClickListener {
            findNavController().navigate(EndGameFragmentDirections.actionGlobalToMainMenuGamesFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}