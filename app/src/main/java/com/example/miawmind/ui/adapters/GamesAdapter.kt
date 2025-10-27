package com.example.miawmind.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miawmind.model.Game

class GamesAdapter (
    private val games: List<Game>,
    private val onGameClick: (Game) -> Unit
): RecyclerView.Adapter<GameViewHolder> () {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): GameViewHolder = GameViewHolder.create(parent,onGameClick)

    override fun onBindViewHolder(
        holder: GameViewHolder,
        position: Int)
    {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size

}