package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.usecase.IEventFetchUseCase

/**
 * Created by KEKE on 2018/10/14.
 */
class EventListPresenterTest {

    private val useCase: IEventFetchUseCase = mock()

    private val presenter = EventListPresenter().apply {
        useCase = this@EventListPresenterTest.useCase
    }

    @Test
    fun `onCreate`() {
        presenter.onCreate()

        verify(useCase).fetchEvent()
    }
}