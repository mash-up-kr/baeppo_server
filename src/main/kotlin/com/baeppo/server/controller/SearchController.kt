package com.baeppo.server.controller

import com.baeppo.server.model.dto.search.response.SearchDto
import com.baeppo.server.service.SearchService
import com.baeppo.server.util.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/search")
class SearchController(
    private val searchService: SearchService
) {

    companion object : Logger

    @GetMapping()
    fun getSearch(@RequestParam(
        required = true
    ) name: String): ResponseEntity<SearchDto> {
        val response = SearchDto(
            id = 1,
            count = 10,
            latitude = 127.007593,
            longitude = 37.489207,
            address = "서울특별시 서초구 서초3동 1503-6"
        )
        return ResponseEntity(response, HttpStatus.OK)
    }

}