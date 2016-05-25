package io.zeringue.vindinium.client

import com.fasterxml.jackson.annotation.JsonProperty as Key

data class Game(
        @Key("id") val id: String,
        @Key("turn") val turn: Int,
        @Key("maxTurns") val maxTurns: Int,
        @Key("heroes") val heroes: List<Hero>,
        @Key("board") val board: Board,
        @Key("finished") val finished: Boolean)
