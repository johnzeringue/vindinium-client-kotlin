package io.zeringue.vindinium.client

import org.glassfish.jersey.jackson.JacksonFeature
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.MediaType.APPLICATION_JSON

/**
 * A Vindinium bot.
 *
 * @param key the secret key used for identification
 */
class Client(val key: String) {

    private val client = ClientBuilder
            .newClient()
            .register(ObjectMapperProvider::class.java)
            .register(JacksonFeature::class.java)

    /**
     * Start and play a game on the official server.
     *
     * @param bot the bot with which to play
     * @param mode the game mode
     * @return the final game state
     */
    fun play(bot: Bot, mode: Mode) = play(bot, mode.url)

    private fun target(url: String) = client
            .target(url)
            .queryParam("key", key)

    /**
     * Start and play a game.
     *
     * @param bot the bot with which to play
     * @param url the new game URL
     * @return the final game state
     */
    fun play(bot: Bot, url: String): Data {
        val gameResponse = target(url)
                .request(APPLICATION_JSON)
                .post(null)

        var data = gameResponse.readEntity(Data::class.java)
        val moveTarget = target(data.playUrl)

        while (!data.game.finished) {
            val move = bot.move(data)

            val moveResponse = moveTarget
                    .queryParam("dir", serializeMove(move))
                    .request(APPLICATION_JSON)
                    .post(null)

            if (moveResponse.status == 400) break
            data = moveResponse.readEntity(Data::class.java)
        }

        return data
    }

}
