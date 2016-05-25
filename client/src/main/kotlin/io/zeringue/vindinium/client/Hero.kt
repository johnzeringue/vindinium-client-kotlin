package io.zeringue.vindinium.client

import com.fasterxml.jackson.annotation.JsonProperty as Key

data class Hero(
        @Key("id") val id: Int,
        @Key("name") val name: String,
        @Key("userId") val userId: String?,
        @Key("elo") val elo: Int,
        @Key("pos") val pos: Position,
        @Key("lastDir") val lastDir: String?,
        @Key("life") val life: Int,
        @Key("gold") val gold: Int,
        @Key("mineCount") val mineCount: Int,
        @Key("spawnPos") val spawnPos: Position,
        @Key("crashed") val crashed: Boolean)
