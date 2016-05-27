package io.zeringue.vindinium.client

import javax.ws.rs.ProcessingException
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.MediaType.APPLICATION_JSON

/**
 * A Vindinium bot.
 *
 * @param key the secret key used for identification
 */
class Client(val key: String) {

    private fun target(url: String) = ClientBuilder
            .newClient()
            .target(url)
            .queryParam("key", key)

    /**
     * Start and play a game on the official server.
     *
     * @param bot the bot with which to play
     * @param mode the game mode
     * @return the final game state
     */
    fun play(bot: Bot, mode: Mode) = play(bot, mode.url)

    /**
     * Start and play a game.
     *
     * @param bot the bot with which to play
     * @param url the new game URL
     * @return the final game state
     */
    fun play(bot: Bot, url: String): Data {
        val initialTarget = target(url)
        var failures = 0

        var response = initialTarget
                .request(APPLICATION_JSON)
                .post(null)

        var data = response.readEntity(Data::class.java)

        var moveTarget = target(data.playUrl)

        while (!data.game.finished) {
            val move = bot.move(data)

            try {
                response = moveTarget
                        .queryParam("dir", move)
                        .request(APPLICATION_JSON)
                        .post(null)
            } catch (ex: ProcessingException) {
                println("ProcessingException: ${ex.message}")
                failures += 1
                if (failures >= 5) break
                continue
            }

            if (response.status != 200) {
                println("Non-200 Response: ${response.readEntity(String::class.java)}")
                failures += 1
                if (failures >= 5) break
                continue
            }

            data = response.readEntity(Data::class.java)
        }

        return data
    }

}
