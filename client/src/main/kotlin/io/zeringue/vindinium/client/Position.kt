package io.zeringue.vindinium.client

import com.fasterxml.jackson.annotation.JsonIgnore

data class Position(
        val x: Int,
        val y: Int) {

    fun north() = this.copy(x = x - 1)
    fun south() = this.copy(x = x + 1)
    fun east() = this.copy(y = y + 1)
    fun west() = this.copy(y = y - 1)

    @get:JsonIgnore
    val neighbors by lazy {
        listOf(north(), south(), east(), west())
    }

}
