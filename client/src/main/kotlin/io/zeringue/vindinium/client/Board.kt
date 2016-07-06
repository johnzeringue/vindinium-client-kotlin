package io.zeringue.vindinium.client

import com.fasterxml.jackson.annotation.JsonIgnore

data class Board(
        val size: Int,
        val tiles: String) {

    private fun lazyFind(matches: (Tile) -> Boolean) = lazy {
        val result = mutableSetOf<Position>()

        for (x in 0 until size) {
            for (y in 0 until size) {
                if (matches(get(x, y))) {
                    result.add(Position(x, y))
                }
            }
        }

        result
    }

    @get:JsonIgnore
    val mines: Set<Position> by lazyFind { it is Tile.Mine }

    @get:JsonIgnore
    val taverns: Set<Position> by lazyFind { it is Tile.Tavern }

    operator fun contains(pos: Position) = contains(pos.x, pos.y)

    fun contains(x: Int, y: Int): Boolean {
        return x >= 0 && x < size && y >= 0 && y < size
    }

    operator fun get(pos: Position) = get(pos.x, pos.y)

    operator fun get(x: Int, y: Int): Tile {
        return (x * size * 2 + y * 2).let {
            Tile.valueOf(tiles.substring(it, it + 2))
        }
    }

}
