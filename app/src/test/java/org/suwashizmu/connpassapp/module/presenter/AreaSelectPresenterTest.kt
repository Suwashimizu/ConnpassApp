package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.*
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.input.AreaSelectInputData
import org.suwashizmu.connpassapp.module.router.IWizardRouter
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectPresenterTest {

    private val useCase: IAreaSelectUseCase = mock()
    private val router: IWizardRouter = mock()

    private val subject: AreaSelectSubject = mock()

    private val presenter = AreaSelectPresenter().apply {
        subject = this@AreaSelectPresenterTest.subject
        useCase = this@AreaSelectPresenterTest.useCase
        router = this@AreaSelectPresenterTest.router
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
        verify(router).gotoInterestSelect()
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

    @Test
    fun `outputPort complete`() {
        presenter.complete(Area.TOKYO, listOf(InterestCategory.AI))

        verify(router).gotoEventList()
    }


    @Test
    fun `outputPort complete when area is null`() {
        presenter.complete(null, listOf(InterestCategory.AI))

        verify(router, never()).gotoEventList()
    }


    @Test
    fun `outputPort complete when InterestCategory is null`() {
        presenter.complete(Area.TOKYO, null)

        verify(router, never()).gotoEventList()
    }
}