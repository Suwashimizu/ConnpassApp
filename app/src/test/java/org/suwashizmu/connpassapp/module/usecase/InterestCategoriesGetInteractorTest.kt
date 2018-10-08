package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.presenter.IInterestCategoriesPresenter
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategoriesGetInteractorTest {

    private val presenter: IInterestCategoriesPresenter = mock()
    private val repository: InterestCategoryRepository = mock()
    private val interactor = InterestCategoriesGetInteractor(presenter, repository)

    @Test
    fun getInterestCategories() {

        interactor.getInterestCategories()

        verify(repository).getInterestCategories()
        verify(presenter).completeInterestCategories(any())
    }
}