package io.zeringue.vindinium.client

data class Game(
        val id: String,
        val turn: Int,
        val maxTurns: Int,
        val heroes: List<Hero>,
        val board: Board,
        val finished: Boolean)
