package io.zeringue.vindinium.client

internal fun serializeMove(move: Move): String {
    return move.toString().toLowerCase().capitalize()
}
