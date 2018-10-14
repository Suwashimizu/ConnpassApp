package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.output.InterestCateoriesOutput
import org.suwashizmu.connpassapp.module.router.IWizardRouter
import org.suwashizmu.connpassapp.module.usecase.InterestCategoriesGetUseCase
import org.suwashizmu.connpassapp.module.usecase.InterestCategorySelectUseCase
import org.suwashizmu.connpassapp.module.view.InterestCategoriesViewModel

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategoriesPresenterTest {

    private val getUseCase: InterestCategoriesGetUseCase = mock()
    private val selectUseCase: InterestCategorySelectUseCase = mock()
    private val router: IWizardRouter = mock()

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
        presenter.router = router
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
        val output = InterestCateoriesOutput(setOf(InterestCategory.AI, InterestCategory.C_SHAPE), true)

        presenter.completeEntry(output)

        //completeしている
        val viewModel = InterestCategoriesViewModel(
                inputState = InterestCategoriesViewModel.InputState.COMPLETE,
                selectCategories = setOf(InterestCategory.AI, InterestCategory.C_SHAPE)
        )

        verify(subject).update(eq(viewModel))
        verify(router).gotoEnventList()

    }

    @Test
    fun `completeEntry when Error`() {
        val output = InterestCateoriesOutput(emptySet(), false)

        presenter.completeEntry(output)

        //completeしていなければErrorとなる
        val viewModel = InterestCategoriesViewModel(
                inputState = InterestCategoriesViewModel.InputState.ERROR,
                selectCategories = emptySet()
        )

        verify(subject).update(eq(viewModel))
    }
}