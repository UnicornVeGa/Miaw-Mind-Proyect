package com.example.miawmind.ui.fragments.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentMainMenuGamesBinding
import com.example.miawmind.databinding.FragmentStartGameBinding

class StartGameFragment : Fragment() {

    private var _binding: FragmentStartGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStartGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: StartGameFragmentArgs by navArgs()
        val game = args.selectedGame

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.myToolbar)
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar

        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
        binding.myToolbar.setupWithNavController(findNavController())
        setHasOptionsMenu(true)

        binding.apply {
            tvGameName.text = game.name
            tvGameDescription.text = game.description
            btnStarGame.setOnClickListener {
                findNavController().navigate(StartGameFragmentDirections.actionStartGameFragmentToGamePlayFragment())
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.help_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_help -> {
                Toast.makeText(requireContext(), getString(R.string.show_help), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}