package com.example.miawmind.model

import android.content.Context
import com.example.miawmind.R

object GameDataSource {

    fun getGames(context: Context): List<Game> {
        return listOf(
            Game(
                0,
                context.getString(R.string.game_memory_name),
                context.getString(R.string.game_memory_type),
                context.getString(R.string.game_memory_desc)
            ),
            Game(
                1,
                context.getString(R.string.game_music_name),
                context.getString(R.string.game_music_type),
                context.getString(R.string.game_music_desc)
            ),
            Game(
                2,
                context.getString(R.string.game_math_name),
                context.getString(R.string.game_math_type),
                context.getString(R.string.game_math_desc)
            ),
            Game(
                3,
                context.getString(R.string.game_reflex_name),
                context.getString(R.string.game_reflex_type),
                context.getString(R.string.game_reflex_desc)
            ),
            Game(
                4,
                context.getString(R.string.game_pairs_name),
                context.getString(R.string.game_pairs_type),
                context.getString(R.string.game_pairs_desc)
            )
        )
    }

    fun countGames(context: Context): Int {
        return getGames(context).size
    }

    fun getGameAt(context: Context, index: Int): Game {
        return getGames(context)[index]
    }
}
