package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.input.EventSearchInputData
import org.suwashizmu.connpassapp.module.presenter.IEventSearchPresenter
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.threeten.bp.ZonedDateTime

/**
 * Created by KEKE on 2018/10/06.
 */
class EventSearchInteractorTest {

    private val result = listOf(Event(
            1,
            "title",
            "catch",
            "description",
            "eventUrl",
            "twitterHashTag",
            ZonedDateTime.now(),
            ZonedDateTime.now(),
            10,
            "address",
            "place",
            10,
            5))

    private val repository: EventRepository = mock {
        on { findEvent(any()) } doReturn Single.create<Collection<Event>> { emitter ->
            emitter.onSuccess(result)
        }
    }
    private val presenter: IEventSearchPresenter = mock()

    private val interactor = EventSearchInteractor(repository, presenter)

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `search`() {

        interactor.search(EventSearchInputData(keyword = setOf("kotlin"), ym = 201802))

        verify(repository).findEvent(any())

        verify(presenter).complete(any())
    }
}