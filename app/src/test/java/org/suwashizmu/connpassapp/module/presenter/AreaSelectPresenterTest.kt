package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.input.AreaSelectInputData
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase
import org.suwashizmu.connpassapp.module.view.IAreaSelectView

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectPresenterTest {

    private val view: IAreaSelectView = mock()
    private val useCase: IAreaSelectUseCase = mock()

    private val presenter = AreaSelectPresenter().apply {
        view = this@AreaSelectPresenterTest.view
        useCase = this@AreaSelectPresenterTest.useCase
    }

    @Test
    fun `completeAreaList`() {
        presenter.completeAreaList(Area.values().toList())

        verify(view).update(any())
    }

    @Test
    fun completeSelected() {
        presenter.completeSelected(Area.TOKYO)

        verify(view).update(any())
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