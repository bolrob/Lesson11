package application.controller
import application.dto.RequestLogin
import application.dto.RequestUser
import application.service.RegisterService
import org.springframework.web.bind.annotation.*

@RestController
//f
class LoginController(
    val registerService: RegisterService
) {
    @PostMapping("/users")
    fun register(@RequestBody login: RequestLogin) = registerService.register(login)
}