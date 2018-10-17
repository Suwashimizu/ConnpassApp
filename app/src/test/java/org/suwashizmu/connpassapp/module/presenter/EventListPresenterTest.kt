package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.suwashizmu.connpassapp.module.input.EventFetchInputData
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
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

        verify(useCase).fetchEvent(EventFetchInputData(0, 30))
    }

    @Test
    fun onResume() {

    }

    @Test
    fun onPause() {

    }

    @Test
    fun onDestroy() {
        presenter.onDestroy()

        assertThat(presenter.router).isNull()
        assertThat(presenter.useCase).isNull()
    }

    @Test
    fun `hasNextEvents when eventList is NotEmpty`() {

        val test = presenter.subject.observable.test()

        presenter.complete(EventSearchOutputData(listOf(EventSearchOutputData.OutputEvent("title", "catch", "description")), null))

        test.assertValue { it.hasNextEvents }
    }


    @Test
    fun `not hasNextEvent when eventList is empty`() {

        val test = presenter.subject.observable.test()

        presenter.complete(EventSearchOutputData(emptyList(), null))

        test.assertValue { it.hasNextEvents.not() }
        test.assertValue { it.refreshing.not() }
    }

    @Test
    fun onPullRefresh() {

        presenter.onPullRefresh()

        verify(useCase).fetchEvent(any())
    }
}