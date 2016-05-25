@file:JvmName("Main")

package io.zeringue.vindinium.sample

import io.zeringue.vindinium.client.Client
import io.zeringue.vindinium.client.Mode.TRAINING

fun main(args: Array<String>) {
    // Set client to Client("YOUR-SECRET-KEY")
    val client: Client? = null
    val bot = RandomBot()

    client?.play(bot, TRAINING) ?: error("No client provided. See the README.")
}
