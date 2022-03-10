package homeWorkGatling

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulationFloodIO extends Simulation {

  //timers values
  val th_time_min = 1
  val th_time_max = 3

  val httpProtocol = http
    .baseUrl("https://challenge.flood.io")
    .inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*css.*""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("uk-UA,uk;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:97.0) Gecko/20100101 Firefox/97.0")
    .disableFollowRedirect


  val scn = scenario("RecordedSimulationFloodIO")
    .exec(http("Open Homepage")
      .get("/")
      .check(css("input[name='authenticity_token']", "value").find.saveAs("authenticity_token"))
      .check(regex(".*step_id.*value=\"(.*?)\"").find.saveAs("step_id")))
    .pause(th_time_min)

    .exec(http("Click on Start button")
      .post("/start")
      .formParam("utf8", "✓")
      .formParam("authenticity_token", "${authenticity_token}")
      .formParam("challenger[step_id]", "${step_id}")
      .formParam("challenger[step_number]", "1")
      .formParam("commit", "Start")
      .check(status.is(302)))
    .pause(th_time_min)

    //adding manually get quest page
    .exec(http("Select age from dropdown")
      .get("/step/2")
      .check(regex(".*step_id.*value=\"(.*?)\"").find.saveAs("step_id")))

    .exec(http("Click on Next after age selection")
      .post("/start")
      .formParam("utf8", "✓")
      .formParam("authenticity_token", "${authenticity_token}")
      .formParam("challenger[step_id]", "${step_id}")
      .formParam("challenger[step_number]", "2")
      .formParam("challenger[age]", "32")
      .formParam("commit", "Next")

    )
    .pause(th_time_min)

    //adding manually get quest page
    .exec(http("Please select and enter the largest order value below ...")
      .get("/step/3")
      .check(regex(".*step_id.*value=\"(.*?)\"").find.saveAs("step_id"))
      //max value
      .check(css(".collection_radio_buttons").findAll.transform(list => list.map(_.toInt).max).saveAs("largest_order"))
      //checked checkbox value
      .check(regex(".*order_selected.*value=\"(.*?)\"").find.saveAs("order_selected")))

    .exec(http("Click on Next after age max number selection and entering")
      .post("/start")
      .formParam("utf8", "✓")
      .formParam("authenticity_token", "${authenticity_token}")
      .formParam("challenger[step_id]", "${step_id}")
      .formParam("challenger[step_number]", "3")
      .formParam("challenger[largest_order]", "${largest_order}")
      .formParam("challenger[order_selected]", "${order_selected}")
      .formParam("commit", "Next"))
    .pause(th_time_min)

    //adding manually get quest page
    .exec(http("Click next when you're ready.")
      .get("/step/4")
      //.check(regex(".*step_id.*value=\"(.*?)\"").find.saveAs("step_id")))
      .check(css("input#challenger_step_id", "value").find.saveAs("step_id")))

    .exec(http("Just clicking on Next")
      .post("/start")
      .formParam("utf8", "✓")
      .formParam("authenticity_token", "${authenticity_token}")
      .formParam("challenger[step_id]", "${step_id}")
      .formParam("challenger[step_number]", "4")
      .formParam("challenger[order_2]", "1645198949")
      .formParam("challenger[order_3]", "1645198949")
      .formParam("challenger[order_8]", "1645198949")
      .formParam("challenger[order_7]", "1645198949")
      .formParam("challenger[order_10]", "1645198949")
      .formParam("challenger[order_14]", "1645198949")
      .formParam("challenger[order_10]", "1645198949")
      .formParam("challenger[order_9]", "1645198949")
      .formParam("challenger[order_9]", "1645198949")
      .formParam("challenger[order_14]", "1645198949")
      .formParam("commit", "Next"))
    .pause(th_time_min)

    //adding manually get quest page
    .exec(http("Please enter your one time token displayed above ...")
      .get("/step/5")
      .check(css("span.token").find.saveAs("one_time_token"))
      .check(css("input#challenger_step_id", "value").find.saveAs("step_id")))

    .exec(http("Click on Next after token entering")
      .post("/start")
      .formParam("utf8", "✓")
      .formParam("authenticity_token", "${authenticity_token}")
      .formParam("challenger[step_id]", "${step_id}")
      .formParam("challenger[step_number]", "5")
      .formParam("challenger[one_time_token]", "${one_time_token}")
      .formParam("commit", "Next"))

    //adding manually get quest page
    .exec(http("Done page")
      .get("/step/5")
      .check(css("input#challenger_step_id", "value").find.saveAs("step_id")))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}