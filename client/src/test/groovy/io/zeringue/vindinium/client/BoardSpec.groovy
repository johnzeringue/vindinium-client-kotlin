package io.zeringue.vindinium.client

import spock.lang.Specification

class BoardSpec extends Specification {

    def board = new Board(18, """\
##############        ##############
##############        ##############
################    ################
##############\$4    \$4##############
##############  @4    ##############
##########  @1##    ##    ##########
##########  []        []  ##########
########        ####        ########
############  \$4####\$4  ############
############  \$4####\$4  ############
########        ####        ########
##########  []        []  ##########
##########  @2##    ##@3  ##########
##############        ##############
##############\$-    \$-##############
################    ################
##############        ##############
##############        ##############""".replaceAll("\n", ""))

    def "board contains #pos is #value"(pos, value) {
        expect:
        board.contains(pos) == value

        where:
        pos                  | value
        new Position(0, 0)   | true
        new Position(17, 0)  | true
        new Position(0, 17)  | true
        new Position(8, 8)   | true
        new Position(17, 17) | true
        new Position(-1, -1) | false
        new Position(-1, 0)  | false
        new Position(0, -1)  | false
        new Position(18, 18) | false
        new Position(27, 8)  | false
    }

    def "board get #pos is #tile"(pos, tile) {
        expect:
        board.get(pos) == tile

        where:
        pos                  | tile
        new Position(0, 0)   | "##"
        new Position(17, 0)  | "##"
        new Position(0, 17)  | "##"
        new Position(8, 7)   | "\$4"
        new Position(17, 17) | "##"
        new Position(6, 6)   | "[]"
        new Position(6, 7)   | "  "
    }

}