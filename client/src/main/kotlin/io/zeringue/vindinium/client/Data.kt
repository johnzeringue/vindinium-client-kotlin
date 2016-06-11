package io.zeringue.vindinium.client

data class Data(
        val game: Game,
        val hero: Hero,
        val token: String,
        val viewUrl: String,
        val playUrl: String)
