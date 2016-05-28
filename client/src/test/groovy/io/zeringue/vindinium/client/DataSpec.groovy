package io.zeringue.vindinium.client

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

import static io.zeringue.vindinium.client.Move.SOUTH

class DataSpec extends Specification {

    def objectMapper = new ObjectMapper()

    def "data deserializes from sample JSON"() {
        expect:
        def data = objectMapper.readValue(sampleJson, Data)

        data.game.id == "s2xh3aig"
        data.hero.lastDir == SOUTH
        data.token == "lte0"
        data.viewUrl == "http://localhost:9000/s2xh3aig"
        data.playUrl == "http://localhost:9000/api/s2xh3aig/lte0/play"
    }

    def "data serializes and deserializes into itself"() {
        given:
        def data = objectMapper.readValue(sampleJson, Data)

        expect:
        def serializedData = objectMapper.writeValueAsString(data)
        objectMapper.readValue(serializedData, Data) == data
    }

    def sampleJson = """
{
   "game":{
      "id":"s2xh3aig",
      "turn":1100,
      "maxTurns":1200,
      "heroes":[
         {
            "id":1,
            "name":"vjousse",
            "userId":"j07ws669",
            "elo":1200,
            "pos":{
               "x":5,
               "y":6
            },
            "life":60,
            "gold":0,
            "mineCount":0,
            "spawnPos":{
               "x":5,
               "y":6
            },
            "crashed":true
         },
         {
            "id":2,
            "name":"vjousse",
            "userId":"j07ws669",
            "elo":1200,
            "pos":{
               "x":12,
               "y":6
            },
            "life":100,
            "gold":0,
            "mineCount":0,
            "spawnPos":{
               "x":12,
               "y":6
            },
            "crashed":true
         },
         {
            "id":3,
            "name":"vjousse",
            "userId":"j07ws669",
            "elo":1200,
            "pos":{
               "x":12,
               "y":11
            },
            "life":80,
            "gold":0,
            "mineCount":0,
            "spawnPos":{
               "x":12,
               "y":11
            },
            "crashed":true
         },
         {
            "id":4,
            "name":"vjousse",
            "userId":"j07ws669",
            "elo":1200,
            "pos":{
               "x":4,
               "y":8
            },
            "lastDir": "South",
            "life":38,
            "gold":1078,
            "mineCount":6,
            "spawnPos":{
               "x":5,
               "y":11
            },
            "crashed":false
         }
      ],
      "board":{
         "size":18,
         "tiles":"##############        ############################        ##############################    ##############################\$4    \$4############################  @4    ########################  @1##    ##    ####################  []        []  ##################        ####        ####################  \$4####\$4  ########################  \$4####\$4  ####################        ####        ##################  []        []  ####################  @2##    ##@3  ########################        ############################\$-    \$-##############################    ##############################        ############################        ##############"
      },
      "finished":true
   },
   "hero":{
      "id":4,
      "name":"vjousse",
      "userId":"j07ws669",
      "elo":1200,
      "pos":{
         "x":4,
         "y":8
      },
      "lastDir": "South",
      "life":38,
      "gold":1078,
      "mineCount":6,
      "spawnPos":{
         "x":5,
         "y":11
      },
      "crashed":false
   },
   "token":"lte0",
   "viewUrl":"http://localhost:9000/s2xh3aig",
   "playUrl":"http://localhost:9000/api/s2xh3aig/lte0/play"
}
"""

}