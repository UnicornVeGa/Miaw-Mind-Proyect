package com.example.miawmind.ui.fragments.profile

import StatisticsGameAdapter
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.content.edit
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.R
import com.example.miawmind.databinding.FragmentMainMenuProfileBinding
import com.example.miawmind.databinding.FragmentSettingsBinding
import com.example.miawmind.model.GameStatistic
import com.example.miawmind.utils.Constants


class MainMenuProfileFragment : Fragment() {
    private var _binding: FragmentMainMenuProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMenuProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val sp = requireContext().getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE)

        val userName = sp.getString(Constants.KEY_NAME, getString(R.string.name_example))

        binding.etName.setText(userName)

        binding.btnEditName.setOnClickListener {
            sp.edit {
                putString(Constants.KEY_NAME, binding.etName.text.toString())
            }
        }

        recyclerView = binding.rvCarousel

        val games = listOf(
            GameStatistic(getString(R.string.game_1_name_recuerdameaw), 120, "30s"),
            GameStatistic(getString(R.string.game_2_name_miaw_miau), 95, "22s"),
            GameStatistic(getString(R.string.game_3_name_cuenta_gatitos), 200, "45s"),
            GameStatistic(getString(R.string.game_4_name_atrapa_el_raton), 150, "60s"),
            GameStatistic(getString(R.string.game_5_name_memoramiaw), 180, "40s")
        )

        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = StatisticsGameAdapter(games)

        binding.btnSettings.setOnClickListener{
            findNavController().navigate(MainMenuProfileFragmentDirections.actionMainMenuProfileFragmentToSettingsFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
