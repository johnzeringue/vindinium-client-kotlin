package io.zeringue.vindinium.client

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

import static io.zeringue.vindinium.client.Move.*

class MoveSpec extends Specification {

    def objectMapper = new ObjectMapper()

    def "utils serialize #move to #capitalizedName"(move, capitalizedName) {
        expect:
        MoveUtilsKt.serializeMove(move) == capitalizedName

        where:
        move  | capitalizedName
        NORTH | 'North'
        SOUTH | 'South'
        EAST  | 'East'
        WEST  | 'West'
        STAY  | 'Stay'
    }

    def "Jackson serializes #move to #capitalizedName"(move, capitalizedName) {
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

    def "Jackson deserializes #capitalizedName to #move"(capitalizedName, move) {
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
