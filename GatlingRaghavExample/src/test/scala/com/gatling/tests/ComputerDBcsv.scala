package com.gatling.tests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class ComputerDBcsv extends Simulation {
  //timers values
  val th_time_min = 1
  val th_time_max = 3

  private val httpProtocol = http
    .baseUrl("https://computer-database.gatling.io")
    .inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""))
  // .disableFollowRedirect

  val csvFeeder = csv("data/computer.csv").circular

  private val scn = scenario("ComputerDBcsv")

    .repeat(4) {
      feed(csvFeeder)
        .exec(http("Opening computers page")
          .get("/computers")
          .check(status.is(200))
        )
        .pause(th_time_min, th_time_max)
        .exec(http("Opening new computers page")
          .get("/computers/new")
          .check(status.is(200))
        )
        .pause(th_time_min, th_time_max)
        .exec(http("Sending new computer info")
          .post("/computers")
          .formParam("name", "${computerName}")
          .formParam("introduced", "${introduced}")
          .formParam("discontinued", "${discontinued}")
          .formParam("company", "${companyId}")
          .check(status.is(200))
        )
        .pause(th_time_min, th_time_max)
        .exec(http("Searching for new record")
          .get("/computers?f=${computerName}")
          .check(css(".well>em") is ("Nothing to display"))
        )
        .pause(th_time_min, th_time_max)
        .exec(http("Get single record")
          .get("/computers?f=ARRA")
          .check(css("td>a") is ("ARRA"))
        )
        .pause(th_time_min, th_time_max)
        .exec(http("Edit record")
          .get("/computers?f=${computerName}")
          .check(status.is(200))
        )
    }

  //  setUp(scn.inject(nothingFor(5 seconds),atOnceUsers(1),
  //    rampUsers(5) during(10 seconds),
  //    constantUsersPerSec(1) during(10  seconds)).protocols(httpProtocol))

  setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}
