package io.zeringue.vindinium.client

import com.fasterxml.jackson.annotation.JsonProperty as Key

data class Board(
        @Key("size") val size: Int,
        @Key("tiles") val tiles: String) {

    operator fun contains(pos: Position): Boolean {
        return pos.run { x >= 0 && x < size && y >= 0 && y < size }
    }

    operator fun get(pos: Position) = get(pos.x, pos.y)

    operator fun get(x: Int, y: Int): String {
        return (y * size * 2 + x * 2).let {
            tiles.substring(it, it + 2)
        }
    }

}
