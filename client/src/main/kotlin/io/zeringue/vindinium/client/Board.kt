package io.zeringue.vindinium.client

data class Board(
        val size: Int,
        val tiles: String) {

    operator fun contains(pos: Position): Boolean {
        return pos.run { x >= 0 && x < size && y >= 0 && y < size }
    }

    operator fun get(pos: Position) = get(pos.x, pos.y)

    operator fun get(x: Int, y: Int): String {
        return (x * size * 2 + y * 2).let {
            tiles.substring(it, it + 2)
        }
    }

}
