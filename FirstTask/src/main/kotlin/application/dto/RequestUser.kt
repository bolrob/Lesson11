package application.dto

data class RequestUser(
    var gender: Sex,
    var age: Int,
    var firstName: String,
    var lastName: String,
    var login: String?,
) {
    enum class Sex {
        MALE, FEMALE
    }
}