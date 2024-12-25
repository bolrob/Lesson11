package application.data


import application.dao.ResponseLogin
import application.dto.RequestLogin
import application.dto.RequestUser
import org.springframework.stereotype.Repository


@Repository
class UserRepository(
    val userRepository: MutableList<ResponseLogin>

) {
    fun register(loginRequest: RequestLogin, token: String): Int {
        userRepository.add(ResponseLogin(id = userRepository.size, token = token, login = loginRequest.login, user = null, password = loginRequest.password))
        return userRepository.size - 1
    }

    fun addInfo(userRequest: RequestUser, token: String): Int {
        var id = -1
        userRepository.forEach { login ->
            if (login.token == token) {
                login.user = userRequest
                id = login.id!!
            }
        }
        return id
    }
}