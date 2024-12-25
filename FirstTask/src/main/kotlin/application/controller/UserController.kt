package application.controller

import application.dto.RequestUser
import application.service.RegisterService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader


@RestController

class UserController (
    val registerService: RegisterService
    ) {

        @PutMapping("/users")
        fun addInfo(@RequestBody user: RequestUser, @RequestHeader("Authorization") token: String) = registerService.addInfo(user, token)


}