package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.any
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
class AreaSelectPresenterTest {

    private val useCase: IAreaSelectUseCase = mock()

    private val subject: AreaSelectSubject = mock()

    private val presenter = AreaSelectPresenter().apply {
        subject = this@AreaSelectPresenterTest.subject
        useCase = this@AreaSelectPresenterTest.useCase
    }

    @Test
    fun `completeAreaList`() {
        presenter.completeAreaList(Area.values().toList())

        verify(subject).update(any())
    }

    @Test
    fun completeSelected() {
        presenter.completeSelected(Area.TOKYO)

        verify(subject).update(any())
    }

    @Test
    fun fetchAreaList() {
        presenter.fetchAreaList()

        verify(useCase).getAreaList()
    }

    @Test
    fun onNextButtonClick() {
        presenter.onNextButtonClick(Area.TOKYO)

        verify(useCase).select(eq(AreaSelectInputData(Area.TOKYO)))
    }
}