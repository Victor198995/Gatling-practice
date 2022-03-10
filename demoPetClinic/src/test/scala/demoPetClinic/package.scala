import io.gatling.core.Predef._
import io.gatling.http.Predef._
import java.text.SimpleDateFormat
import java.util.Date

package object requests {

  private val headers_0 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache",
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1",
    "sec-ch-ua" -> """Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92""",
    "sec-ch-ua-mobile" -> "?0",
    "x-lb-auth" -> "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVOKAnX0"
  )

  private val headers_46 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Cache-Control" -> "no-cache",
    "Origin" -> "http://localhost:8080",
    "Pragma" -> "no-cache",
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1",
    "sec-ch-ua" -> """Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92""",
    "sec-ch-ua-mobile" -> "?0",
    "x-lb-auth" -> "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVOKAnX0"
  )

  object Homepage {
    val openHomePage = exec(http("Open Home Page").get("/").headers(headers_0))
  }

  object Owner {

    val getFindOwnersPage = exec(http("GET Find Owners Page")
      .get("/owners/find")
      .headers(headers_0))

    val getAddOwnerPage = exec(http("GET Add Owner")
      .get("/owners/new")
      .headers(headers_0))

    val postAddOwner = exec(http("POST Add Owner")
      .post("/owners/new")
      .headers(headers_46)
      .formParam("firstName", "Viktor")
      .formParam("lastName", "K")
      .formParam("address", "test")
      .formParam("city", "Kyiv")
      .formParam("telephone", "1231234")
      .resources(http("Get Owners Info").get("/owners/12").headers(headers_0))
      .check(status.is(302))
    )
    val getFindOwnerByLastName = exec(http("GET Find Owners By LastName")
      .get("/owners?lastName=K")
      .headers(headers_0)
      .resources(http("Get Owners Info").get("/owners/12").headers(headers_0))
      .check(status.is(200)))

    val getEditOwnerPage = exec(http("Get Open Edit Owner Page")
      .get("/owners/12/edit")
      .headers(headers_0))

    val postUpdateOwner = exec(http("POST Update Owner")
      .post("/owners/12/edit")
      .headers(headers_46)
      .formParam("firstName", "Viktor")
      .formParam("lastName", "Ku")
      .formParam("address", "test")
      .formParam("city", "Kyiv")
      .formParam("telephone", "123123")
      .resources(
        http("GET Owners Info")
          .get("/owners/12/edit")
          .headers(headers_0))
      .check(status.is(302)))
  }

  object Pet {
    val getAddPet = exec(http("Get Add Pet")
      .get("/owners/12/pets/new")
      .headers(headers_0))

    val postAddPet = exec(http("POST Add Pet")
      .post("/owners/12/pets/new")
      .headers(headers_46)
      .formParam("id", "")
      .formParam("name", "Eel2")
      .formParam("birthDate", "")
      .formParam("type", "lizard")
      .resources(http("Get owners Info")
        .get("/owners/12")
        .headers(headers_0))
      .check(status.is(200)))

    val getEditPetPage = exec(http("Get Edit Pet Page")
      .get("/owners/12/pets/15/edit")
      .headers(headers_0))

    val postEditPetName = exec(http("request_122")
      .post("/owners/12/pets/15/edit")
      .headers(headers_46)
      .formParam("id", "15")
      .formParam("name", "Eel3")
      .formParam("birthDate", "2021/12/05")
      .formParam("type", "lizard")
      .resources(http("Get owners Info")
        .get("/owners/12")
        .headers(headers_0))
      .check(status.is(302)))
  }

  object Visit {
    val getAddNewVisitPage = exec(http("request_137")
      .get("/owners/12/pets/15/visits/new")
      .headers(headers_0))

    val postAddNewVisit = exec(http("request_152")
      .post("/owners/12/pets/15/visits/new")
      .headers(headers_46)
      .formParam("date", getCurrentDate())
      .formParam("description", "dental surgery")
      .formParam("petId", "15")
      .resources(http("Get owners Info")
        .get("/owners/12")
        .headers(headers_0))
      .check(status.is(302)))
  }

  object Vet {
    val getVets = exec(http("GET Vets List")
      .get("/vets")
      .headers(headers_0))
  }

  //Method for date generation
  def getCurrentDate() = {
    new SimpleDateFormat("yyyy/MM/dd").format(new Date).toString
  }

}
