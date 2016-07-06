package io.zeringue.vindinium.client

sealed class Tile {

    companion object {

        fun valueOf(string: String): Tile {
            val heroes = setOf("@1", "@2", "@3", "@4")

            val mines = mapOf(
                    "$-".to(null),
                    "$1".to(1),
                    "$2".to(2),
                    "$3".to(3),
                    "$4".to(4))

            return when (string) {
                "  ", in heroes -> Air
                "[]" -> Tavern
                "##" -> Wall
                in mines -> Mine(mines[string])
                else -> throw IllegalArgumentException()
            }
        }

    }

    object Air : Tile()

    class Mine(val owner: Int?) : Tile() {

        override fun equals(other: Any?) = other is Mine && other.owner == owner

        override fun hashCode(): Int = owner ?: 0

        override fun toString() = "Mine(owner=$owner)"

    }

    object Tavern : Tile()

    object Wall : Tile()

}
