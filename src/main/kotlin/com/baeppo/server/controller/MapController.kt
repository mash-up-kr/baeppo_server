package com.baeppo.server.controller

import com.baeppo.server.model.dto.map.response.MapDto
import com.baeppo.server.model.dto.map.list.response.MapListDto
import com.baeppo.server.model.dto.map.list.building.response.MapListBuildingDto
import com.baeppo.server.model.dto.map.list.university.response.MapListUniversityDto
import com.baeppo.server.service.MapService
import com.baeppo.server.util.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/map")
class MapController(
    private val mapService: MapService
) {

    companion object : Logger

    @GetMapping()
    fun getSearch(@RequestParam(required = true)
                  leftLatitude: Double,
                  topLongitude: Double,
                  rightLatitude: Double,
                  bottomLongitude: Double
    ): ResponseEntity<MapDto> {
        val response = MapDto(
            id = 1,
            count = 10,
            latitude = 127.007593,
            longitude = 37.489207
        )
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/list")
    fun getListByRect(@RequestParam(required = true)
                  leftLatitude: Double,
                  topLongitude: Double,
                  rightLatitude: Double,
                  bottomLongitude: Double
    ): ResponseEntity<MapListDto> {
        val response = MapListDto()
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/list/university")
    fun getListByUniversity(@RequestParam(required = true)
                            name: String,
                            filter: String
    ): ResponseEntity<MapListUniversityDto> {
        val response = MapListUniversityDto()
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/list/building")
    fun getListByBuilding(@RequestParam(required = true)
                            name: String,
                            filter: String
    ): ResponseEntity<MapListBuildingDto> {
        val response = MapListBuildingDto()
        return ResponseEntity(response, HttpStatus.OK)
    }

}