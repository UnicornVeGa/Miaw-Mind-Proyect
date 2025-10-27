package com.example.miawmind.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.databinding.GameElementBinding
import com.example.miawmind.model.Game

class GameViewHolder (
    private val binding: GameElementBinding,
    private val onGameClick: (Game) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    private var currentItem: Game? = null

    init {
        binding.root.setOnClickListener {
            currentItem?.let(onGameClick)
        }
    }

    fun bind(game: Game) {
        currentItem = game
        binding.tvGameName.text = game.name
        binding.tvGameAbility.text = game.ability
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onGameClick: (Game) -> Unit
        ): GameViewHolder {
            val binding = GameElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return GameViewHolder(binding, onGameClick)
        }
    }

}