package com.example.miawmind.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.R
import com.example.miawmind.databinding.ItemGameCardBinding
import com.example.miawmind.model.GameStatistic

class StatisticsGameHolder(
    private val binding: ItemGameCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(game: GameStatistic) {
        binding.tvGameName.text = game.name
        binding.tvHighScore.text = binding.root.context.getString(R.string.highest_score, game.maxScore)
        binding.tvBestTime.text = binding.root.context.getString(R.string.best_time, game.bestTime)
    }
}
