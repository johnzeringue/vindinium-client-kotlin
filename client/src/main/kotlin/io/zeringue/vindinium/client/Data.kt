package io.zeringue.vindinium.client

import com.fasterxml.jackson.annotation.JsonProperty as Key

data class Data(
        @Key("game") val game: Game,
        @Key("hero") val hero: Hero,
        @Key("token") val token: String,
        @Key("viewUrl") val viewUrl: String,
        @Key("playUrl") val playUrl: String)
