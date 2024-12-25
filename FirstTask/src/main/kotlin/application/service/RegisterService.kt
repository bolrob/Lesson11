package application.service

import application.dao.ResponseLogin
import application.dao.ResponseUser
import application.dto.RequestLogin
import application.dto.RequestUser
import application.data.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class RegisterService(
    val userRepository: UserRepository
) {

    private fun generateRandomString(length: Int): String {
        val chars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { chars.random() }
            .joinToString("")
    }

    fun register(loginRequest: RequestLogin) : ResponseEntity<ResponseLogin> {
        val token = generateRandomString(Random.nextInt(15, 25))
        val id = userRepository.register(loginRequest, token)
        return ResponseEntity(ResponseLogin(id = id, login = loginRequest.login, user = null, password = loginRequest.password, token = token), HttpStatus.OK)
    }

    fun addInfo(userRequest: RequestUser, token: String): ResponseEntity<ResponseUser> {
        val id = userRepository.addInfo(userRequest, token)
        return ResponseEntity(ResponseUser(id = id, token = token), HttpStatus.OK)
    }
}