package io.zeringue.vindinium.client

/**
 * A Vindinium bot.
 */
interface Bot {

    /**
     * Select a move based on the game state.
     *
     * @param data the lastest server response
     * @return the bot's move
     */
    fun move(data: Data): Move

}
