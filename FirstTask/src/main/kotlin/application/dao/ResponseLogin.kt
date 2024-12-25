package application.dao

import application.dto.RequestUser

data class ResponseLogin(
    val id: Int?,
    var user: RequestUser?,
    val login: String,
    val password: String,
    val token: String,
) {
}