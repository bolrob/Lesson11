package application.client

import application.dao.ResponseUser
import application.dto.RequestLogin
import application.dto.RequestUser
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@FeignClient(name = "userClient", url = "http://localhost:8080/")
interface UserClient {

    @PostMapping(value = ["/users"])
    fun registerUser(@RequestBody loginRequest: RequestLogin): ResponseEntity<ResponseUser>

    @PutMapping(value = ["/users"])
    fun updateUser(@RequestBody userRequest: RequestUser, @RequestHeader("Authorization") token: String): ResponseEntity<ResponseUser>
}