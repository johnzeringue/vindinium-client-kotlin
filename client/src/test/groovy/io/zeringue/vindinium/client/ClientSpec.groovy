package io.zeringue.vindinium.client

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.ClassRule
import spock.lang.Shared
import spock.lang.Specification

import static com.github.tomakehurst.wiremock.client.WireMock.*

class ClientSpec extends Specification {

    @Shared
    @ClassRule
    WireMockRule wireMockRule

    def client = new Client("abc123")

    def "client starts game"() {
        given:
        stubFor(post(urlPathEqualTo("/api/arena"))
                .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody(sampleJson(finished: true))))

        when:
        client.play({ Move.STAY }, "http://localhost:8080/api/arena")

        then:
        verify(postRequestedFor(urlPathEqualTo("/api/arena"))
                .withQueryParam("key", equalTo("abc123")))
    }

    def "client sends bot move"() {
        given:
        stubFor(post(urlPathEqualTo("/api/arena"))
                .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody(sampleJson(finished: false))))

        stubFor(post(urlPathEqualTo("/api/s2xh3aig/lte0/play"))
                .willReturn((aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody(sampleJson(finished: true)))))

        when:
        client.play({ Move.STAY }, "http://localhost:8080/api/arena")

        then:
        verify(postRequestedFor(urlPathEqualTo("/api/s2xh3aig/lte0/play"))
                .withQueryParam("key", equalTo("abc123"))
                .withQueryParam("dir", equalTo("Stay")))
    }

    def sampleJson(args) {
        return """\
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
      "finished":$args.finished
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
   "viewUrl":"http://localhost:8080/s2xh3aig",
   "playUrl":"http://localhost:8080/api/s2xh3aig/lte0/play"
}
"""
    }

}
