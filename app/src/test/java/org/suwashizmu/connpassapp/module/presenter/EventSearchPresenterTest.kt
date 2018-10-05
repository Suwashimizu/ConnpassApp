package org.suwashizmu.connpassapp.module.presenter

import org.junit.Test
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData

/**
 * Created by KEKE on 2018/10/06.
 */
class EventSearchPresenterTest {

    private val presenter = EventSearchPresenter()

    @Test
    fun complete() {
        presenter.complete(EventSearchOutputData(listOf(EventSearchOutputData.OutputEvent("title", "catch", "description"))))
    }
}