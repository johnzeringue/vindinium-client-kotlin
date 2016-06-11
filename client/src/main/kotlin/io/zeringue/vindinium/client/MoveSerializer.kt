package io.zeringue.vindinium.client

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

/**
 * A serializer for [Move]s.
 */
internal class MoveSerializer : JsonSerializer<Move>() {

    override fun serialize(
            value: Move,
            gen: JsonGenerator,
            serializers: SerializerProvider) {

        return gen.writeString(serializeMove(value))
    }

}
