package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.output.EventDetailsOutputPort
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.threeten.bp.ZonedDateTime

/**
 * Created by KEKE on 2018/11/16.
 */
class FetchSingleEventInteractorTest {

    private val result = Event(
            1,
            "title",
            "catch",
            "ownerName",
            "description",
            "eventUrl",
            "twitterHashTag",
            ZonedDateTime.now(),
            ZonedDateTime.now(),
            10,
            "place",
            "address",
            10,
            5)

    private val mockRepository: EventRepository = mock {
        on { findById(10) } doReturn Single.just(result)
        on { findById(11) } doReturn Single.error(IllegalArgumentException("error"))
    }
    private val mockOutputPort: EventDetailsOutputPort = mock()

    private val interactor = FetchSingleEventInteractor(mockRepository, mockOutputPort)

    @Before
    fun setup() {
        //Schedulersの差し替え
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun fetchEvent() {
        interactor.fetchEvent(10)

        verify(mockRepository).findById(any())
        verify(mockOutputPort).complete(any(), eq(null))
    }


    @Test
    fun `fetchEvent when error`() {
        interactor.fetchEvent(11)

        verify(mockRepository).findById(any())
        verify(mockOutputPort).complete(eq(null), any())
    }
}