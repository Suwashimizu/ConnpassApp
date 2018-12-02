package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Completable
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.input.InterestCategoryInputData
import org.suwashizmu.connpassapp.module.output.InterestCateoriesOutput
import org.suwashizmu.connpassapp.module.presenter.IInterestCategoriesPresenter
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategorySelectInteractorTest {

    private val presenter: IInterestCategoriesPresenter = mock()
    private val repository: InterestCategoryRepository = mock {
        on { save(any()) } doReturn Completable.complete()
    }

    private val interactor = InterestCategorySelectInteractor(presenter, repository)

    @Test
    fun select() {
        interactor.select(InterestCategoryInputData(setOf(InterestCategory.RUBY, InterestCategory.AI)))

        verify(repository).save(any())
        verify(presenter).completeEntry(eq(InterestCateoriesOutput(setOf(InterestCategory.RUBY, InterestCategory.AI), true)))
    }

    @Test
    fun `select when error`() {

        val repository: InterestCategoryRepository = mock {
            on { save(any()) } doReturn Completable.error(IllegalStateException("not value"))
        }
        val interactor = InterestCategorySelectInteractor(presenter, repository)

        interactor.select(InterestCategoryInputData(setOf()))

        verify(repository).save(any())
        verify(presenter).completeEntry(eq(InterestCateoriesOutput(emptySet(), false)))
    }
}