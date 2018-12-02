package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.suwashizmu.connpassapp.module.input.EventFetchInputData
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.router.IEventListRouter
import org.suwashizmu.connpassapp.module.usecase.IEventFetchUseCase
import org.suwashizmu.connpassapp.module.view.EventListViewModel

/**
 * Created by KEKE on 2018/10/14.
 */
class EventListPresenterTest {

    private val useCase: IEventFetchUseCase = mock()
    private val mockRouter: IEventListRouter = mock()

    private val presenter = EventListPresenter().apply {
        useCase = this@EventListPresenterTest.useCase
        router = mockRouter
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
    fun `hasNextEvents is True when currentListSize less than totalEventCount`() {

        val test = presenter.subject.observable.test()

        presenter.complete(EventSearchOutputData(listOf(EventSearchOutputData.OutputEvent(1, "title", "catch", "description", "eventUrl")), null, 100))

        test.assertValue { it.hasNextEvents }
    }


    @Test
    fun `hasNextEvents is True when currentListSize greater than totalEventCount`() {

        presenter.complete(EventSearchOutputData(listOf(
                EventSearchOutputData.OutputEvent(1, "title", "catch", "description", "eventUrl"),
                EventSearchOutputData.OutputEvent(2, "title", "catch", "description", "eventUrl")),
                null,
                2))

        val test = presenter.subject.observable.test()

        assertThat(test.valueCount()).isEqualTo(1)
        test.assertValue { it.hasNextEvents.not() }
        test.assertValue { it.refreshing.not() }
    }

    @Test
    fun `hasNextEvent is False when eventList is empty`() {
        presenter.complete(EventSearchOutputData(emptyList(), null, -1))

        val test = presenter.subject.observable.test()

        test.assertValue { it.hasNextEvents.not() }
        test.assertValue { it.refreshing.not() }
        test.assertValue { it.loading.not() }
    }

    @Test
    fun onPullRefresh() {
        presenter.onScrollEnd()

        presenter.onPullRefresh()

        //refreshをしたのでoffsetは0になる
        verify(useCase, times(2)).fetchEvent(check {
            assertThat(it.offset).isEqualTo(0)
        })
    }

    @Test
    fun `onScrollEnd`() {
        presenter.onScrollEnd()

        verify(useCase).fetchEvent(check {
            assertThat(it.offset).isEqualTo(0)
        })
    }

    @Test
    fun onSearchIconClicked() {

        presenter.onSearchIconClicked()

        verify(mockRouter).gotoSearchSettings()
    }

    @Test
    fun onItemClick() {

        presenter.onItemClick(EventListViewModel.Event(10, "catch", "title", "eventUrl"))

        argumentCaptor<Int>().apply {
            verify(mockRouter).gotoEventDetails(capture(),
                    check {
                        assertThat(it).isEqualTo("title")
                    },
                    check {
                        assertThat(it).isEqualTo("eventUrl")
                    })

            assertThat(lastValue).isEqualTo(10)
        }
    }
}