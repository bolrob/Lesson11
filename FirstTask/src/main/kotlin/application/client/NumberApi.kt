package application.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(value = "Testing", url = "http://localhost:8080")
interface NumberApi {
    @GetMapping("/{number}")
    fun makeRequest(@PathVariable("number") num: Long): Long
}