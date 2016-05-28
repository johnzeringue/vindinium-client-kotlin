package io.zeringue.vindinium.client

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

/**
 * A deserializer for [Move]s.
 */
internal class MoveDeserializer : JsonDeserializer<Move>() {

    override fun deserialize(
            p: JsonParser,
            ctxt: DeserializationContext): Move {

        return Move.valueOf(p.getText().toUpperCase())
    }

}
