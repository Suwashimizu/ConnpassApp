package org.suwashizmu.connpassapp.module.controller

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.input.AreaSelectInputData
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectController(private val areaSearchUseCase: IAreaSelectUseCase) {

    fun fetchAreaList() {
        areaSearchUseCase.getAreaList()
    }

    fun onNextButtonClick(area: Area) {
        areaSearchUseCase.select(AreaSelectInputData(area))
    }
}