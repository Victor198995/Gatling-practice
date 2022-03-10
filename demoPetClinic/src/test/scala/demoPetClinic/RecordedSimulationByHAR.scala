package demoPetClinic

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import requests.{Homepage, Owner,Vet,Pet,Visit}
import io.gatling.jdbc.Predef._
//import requests._

class RecordedSimulationByHAR extends Simulation {

  //timers values
  val th_time_min =1
  val th_time_max = 3

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .inferHtmlResources(AllowList(),DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("uk,uk-UA;q=0.9,ru;q=0.8,en-US;q=0.7,en;q=0.6")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36")
   // .disableFollowRedirect

  val newVisitWorkflow = exec(Owner.getFindOwnersPage).pause(th_time_min,th_time_max)
    .exec(Owner.getAddOwnerPage).pause(th_time_min,th_time_max)
    .exec(Owner.postAddOwner).pause(th_time_min,th_time_max)
    .exec(Pet.getAddPet).pause(th_time_min,th_time_max)
    .exec(Pet.postAddPet).pause(th_time_min,th_time_max)
    .exec(Pet.getEditPetPage).pause(th_time_min,th_time_max)
    .exec(Pet.postEditPetName).pause(th_time_min,th_time_max)
    .exec(Visit.getAddNewVisitPage).pause(th_time_min,th_time_max)
    .exec(Visit.postAddNewVisit).pause(th_time_min,th_time_max)

  val consultingWorkflow = exec(Owner.getFindOwnersPage).pause(th_time_min,th_time_max)
    .exec(Owner.getFindOwnerByLastName).pause(th_time_min,th_time_max)
    .exec(Owner.getEditOwnerPage).pause(th_time_min,th_time_max)
    .exec(Owner.postUpdateOwner).pause(th_time_min,th_time_max)
    .exec(Vet.getVets).pause(th_time_min,th_time_max)

  val scn = scenario("RecordedSimulationByHAR")
    .during(60.seconds, exitASAP = false){
      exec(Homepage.openHomePage).pause(th_time_min,th_time_max)
        .randomSwitch(
          80.0 -> newVisitWorkflow,
          20.0 -> consultingWorkflow
        )
    }

  setUp(scn.inject(rampConcurrentUsers(1).to(5).during(5))).protocols(httpProtocol)
}
