package io.zeringue.vindinium.client

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty as Key

data class Position(
        @Key("x") val x: Int,
        @Key("y") val y: Int) {

    fun north() = this.copy(y = y - 1)
    fun south() = this.copy(y = y + 1)
    fun east() = this.copy(x = x + 1)
    fun west() = this.copy(x = x - 1)

    @get:JsonIgnore
    val neighbors by lazy {
        listOf(north(), south(), east(), west())
    }

}
