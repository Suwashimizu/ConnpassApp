package org.suwashizmu.connpassapp.module.controller

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.usecase.IEventSearchUseCase

/**
 * Created by KEKE on 2018/10/06.
 *
 * useCaseの正当な呼び出しをテストする
 */
class EventSearchControllerTest {

    private val useCase: IEventSearchUseCase = mock()

    private val controller = EventSearchController(useCase)

    @Test
    fun eventSearch() {

        controller.eventSearch("kotlin")

        verify(useCase).search(any())
    }
}