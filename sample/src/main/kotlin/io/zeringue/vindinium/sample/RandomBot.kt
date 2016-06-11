package io.zeringue.vindinium.sample

import io.zeringue.vindinium.client.Bot
import io.zeringue.vindinium.client.Data
import io.zeringue.vindinium.client.Move
import java.awt.Desktop.getDesktop
import java.net.URI

/**
 * A Vindinium bot that randomly selects its moves.
 */
class RandomBot : Bot {

    private fun <T> Array<T>.random(): T {
        return get((Math.random() * size).toInt())
    }

    override fun move(data: Data): Move {
        if (data.game.turn < 4) {
            Thread { getDesktop().browse(URI(data.viewUrl)) }.start()
        }

        return Move.values().random()
    }

}
