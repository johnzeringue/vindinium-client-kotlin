package io.zeringue.vindinium.client

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize

/**
 * A move available to [Bot]s.
 */
@JsonSerialize(using = MoveSerializer::class)
@JsonDeserialize(using = MoveDeserializer::class)
enum class Move {

    NORTH, SOUTH, EAST, WEST, STAY

}
