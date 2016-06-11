package io.zeringue.vindinium.client

data class Hero(
        val id: Int,
        val name: String,
        val userId: String?,
        val elo: Int,
        val pos: Position,
        val lastDir: Move?,
        val life: Int,
        val gold: Int,
        val mineCount: Int,
        val spawnPos: Position,
        val crashed: Boolean)
