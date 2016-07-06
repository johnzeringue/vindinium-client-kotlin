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

    def "board has mines"() {
        expect:
        board.mines.size() == 8

        new Position(3, 7) in board.mines
        new Position(8, 7) in board.mines
        new Position(9, 10) in board.mines
        new Position(14, 10) in board.mines
    }

    def "board has taverns"() {
        expect:
        board.taverns.size() == 4

        new Position(6, 6) in board.taverns
        new Position(11, 6) in board.taverns
        new Position(6, 11) in board.taverns
        new Position(11, 11) in board.taverns
    }

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
        new Position(0, 0)   | Tile.Wall.INSTANCE
        new Position(17, 0)  | Tile.Wall.INSTANCE
        new Position(0, 17)  | Tile.Wall.INSTANCE
        new Position(8, 7)   | new Tile.Mine(4)
        new Position(17, 17) | Tile.Wall.INSTANCE
        new Position(6, 6)   | Tile.Tavern.INSTANCE
        new Position(6, 7)   | Tile.Air.INSTANCE
    }

}
