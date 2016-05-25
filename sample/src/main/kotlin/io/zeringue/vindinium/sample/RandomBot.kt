package io.zeringue.vindinium.sample

import io.zeringue.vindinium.client.Bot
import io.zeringue.vindinium.client.Bot.Companion.MOVES
import io.zeringue.vindinium.client.Data
import java.awt.Desktop.getDesktop
import java.net.URI

/**
 * A Vindinium bot that randomly selects its moves.
 */
class RandomBot : Bot {

    private fun <T> List<T>.random(): T {
        return get((Math.random() * size).toInt())
    }

    override fun move(data: Data): String {
        if (data.game.turn == 0) {
            getDesktop().browse(URI(data.viewUrl))
        }

        return MOVES.random()
    }

}