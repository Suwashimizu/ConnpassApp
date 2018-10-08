package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.output.InterestCateoriesOutput
import org.suwashizmu.connpassapp.module.usecase.InterestCategoriesGetUseCase
import org.suwashizmu.connpassapp.module.usecase.InterestCategorySelectUseCase
import org.suwashizmu.connpassapp.module.view.InterestCategoriesViewModel

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategoriesPresenterTest {

    private val getUseCase: InterestCategoriesGetUseCase = mock()
    private val selectUseCase: InterestCategorySelectUseCase = mock()

    private val presenter = InterestCategoriesPresenter()
    private val subject: InterestCategoriesSubject = mock {
        on { observable } doReturn Observable.just(InterestCategoriesViewModel().apply {
            inputState = InterestCategoriesViewModel.InputState.COMPLETE
        })
    }

    @Before
    fun setup() {
        presenter.getUseCase = getUseCase
        presenter.selectUseCase = selectUseCase
        presenter.subject = subject
    }

    @Test
    fun fetchInterestCategories() {
        presenter.fetchInterestCategories()

        verify(getUseCase).getInterestCategories()
    }

    @Test
    fun onClickNextButton() {
        presenter.onClickNextButton(InterestCategory.RUBY, InterestCategory.C_SHAPE, InterestCategory.AI)

        verify(selectUseCase).select(any())
    }

    @Test
    fun completeInterestCategories() {
        //subjectのTest
        presenter.completeInterestCategories(listOf(InterestCategory.RUBY, InterestCategory.AI))

        verify(subject).update(any())
    }

    @Test
    fun `completeEntry when complete`() {
        //subjectのTest
        val test = subject.observable.test()
        val output = InterestCateoriesOutput(setOf(InterestCategory.AI, InterestCategory.C_SHAPE), true)

        presenter.completeEntry(output)

        verify(subject).update(any())

        test.assertNoErrors()
        test.assertValue { it.inputState == InterestCategoriesViewModel.InputState.COMPLETE }
    }

    @Test
    fun `completeEntry when Error`() {

        //Errorを返す時
        whenever(subject.observable).doReturn(Observable.just(InterestCategoriesViewModel().apply { inputState = InterestCategoriesViewModel.InputState.ERROR }))

        //subjectのTest
        val test = subject.observable.test()
        val output = InterestCateoriesOutput(setOf(InterestCategory.AI, InterestCategory.C_SHAPE), true)

        presenter.completeEntry(output)

        verify(subject).update(any())

        test.assertNoErrors()
        test.assertValue { it.inputState == InterestCategoriesViewModel.InputState.ERROR }
    }
}