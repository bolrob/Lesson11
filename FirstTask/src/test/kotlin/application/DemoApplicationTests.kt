package application


import application.client.UserClient
import application.dto.RequestLogin
import application.dto.RequestUser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatusCode

@SpringBootTest
class DemoApplicationTests {
    @Autowired
//    @MockBean
    private lateinit var userClient: UserClient

    @Test
    fun registration() {
        val request = RequestLogin(login = "adolf1489", password = "1029384756")
        val response = userClient.registerUser(request)
        Assertions.assertEquals(HttpStatusCode.valueOf(200), response.statusCode)
    }

    @Test
    fun editUser() {
        val registrationRequest = RequestLogin(login = "megapro1337", password = "000000000")
        val registrationResponse = userClient.registerUser(registrationRequest)
        Assertions.assertEquals(HttpStatusCode.valueOf(200), registrationResponse.statusCode)

        val editRequest = RequestUser(login = null, gender = RequestUser.Sex.MALE, age = 57, lastName = "Adolfov", firstName = "Adolf")
        val editResponse = userClient.updateUser(editRequest, registrationResponse.body!!.token)
        Assertions.assertEquals(HttpStatusCode.valueOf(200), editResponse.statusCode)
    }
}