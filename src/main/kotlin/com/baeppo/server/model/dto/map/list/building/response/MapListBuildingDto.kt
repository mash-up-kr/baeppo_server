package com.baeppo.server.model.dto.map.list.building.response

import com.baeppo.server.model.dto.map.list.response.MapListBaseDto

class MapListBuildingDto(
    val thumbnails: List<String> = emptyList()
) : MapListBaseDto()