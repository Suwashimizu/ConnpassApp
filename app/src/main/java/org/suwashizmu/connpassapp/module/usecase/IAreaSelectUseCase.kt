package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.input.AreaSelectInputData

/**
 * Created by KEKE on 2018/10/06.
 */
interface IAreaSelectUseCase {

    fun getAreaList(): Collection<Area>

    fun select(inputData: AreaSelectInputData)
}