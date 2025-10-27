package com.example.miawmind.ui.fragments.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miawmind.databinding.FragmentMainMenuGamesBinding
import com.example.miawmind.model.GameDataSource
import com.example.miawmind.ui.adapters.GamesAdapter
import com.example.miawmind.utils.Constants
import com.example.miawmind.utils.GridSpacingItemDecoration


class MainMenuGamesFragment : Fragment() {
    private var _binding: FragmentMainMenuGamesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainMenuGamesBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val games = GameDataSource.getGames(requireContext())

        binding.rvGames.apply {
            layoutManager = GridLayoutManager(requireContext(),Constants.NUMBER_OF_MENU_COLUMNS)

            addItemDecoration(
                GridSpacingItemDecoration(2, 40, true)
            )

            adapter = GamesAdapter(games) { selectedGame ->
                findNavController().navigate(
                    MainMenuGamesFragmentDirections.actionMainMenuGamesFragmentToStartGameFragment(selectedGame)
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}