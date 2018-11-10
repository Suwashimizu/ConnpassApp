package org.suwashizmu.connpassapp.module.controller

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.input.EventSearchInputData
import org.suwashizmu.connpassapp.module.usecase.IEventSearchUseCase

/**
 * Created by KEKE on 2018/10/06.
 */
class EventSearchController(private val eventSearchUseCase: IEventSearchUseCase) {

    fun eventSearch(vararg keyword: String) {
        val inputData = EventSearchInputData(
                area = Area.FUKUSHIMA,
                keyword = keyword.toSet(),
                offset = 0,
                limit = 30
        )

        eventSearchUseCase.search(inputData)
    }
}