package org.suwashizmu.connpassapp.module.controller

import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.input.AreaSelectInputData
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectControllerTest {

    private val useCase: IAreaSelectUseCase = mock()
    private val controller = AreaSelectController(useCase)

    @Test
    fun fetchAreaList() {
        controller.fetchAreaList()

        verify(useCase).getAreaList()
    }

    @Test
    fun onNextButtonClick() {
        controller.onNextButtonClick(Area.TOKYO)

        verify(useCase).select(eq(AreaSelectInputData(Area.TOKYO)))
    }
}