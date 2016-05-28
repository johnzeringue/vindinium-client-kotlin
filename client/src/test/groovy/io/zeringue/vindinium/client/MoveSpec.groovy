package io.zeringue.vindinium.client

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

import static io.zeringue.vindinium.client.Move.*

class MoveSpec extends Specification {

    def objectMapper = new ObjectMapper()

    def "#move serializes to #capitalizedName"(move, capitalizedName) {
        expect:
        objectMapper.writeValueAsString(move) == capitalizedName

        where:
        move  | capitalizedName
        NORTH | '"North"'
        SOUTH | '"South"'
        EAST  | '"East"'
        WEST  | '"West"'
        STAY  | '"Stay"'
    }

    def "#capitalizedName deserializes to #move"(capitalizedName, move) {
        expect:
        objectMapper.readValue(capitalizedName, Move) == move

        where:
        capitalizedName | move
        '"North"'       | NORTH
        '"South"'       | SOUTH
        '"East"'        | EAST
        '"West"'        | WEST
        '"Stay"'        | STAY
    }

}
