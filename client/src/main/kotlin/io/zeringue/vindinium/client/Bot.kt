package io.zeringue.vindinium.client

/**
 * A Vindinium bot.
 */
interface Bot {

    companion object {
        /**
         * The moves available to a bot.
         */
        val MOVES = listOf("North", "South", "East", "West", "Stay")
    }

    /**
     * Select a move based on the game state.
     *
     * @param data the lastest server response
     * @return the bot's move, one of [Bot.MOVES]
     */
    fun move(data: Data): String

}