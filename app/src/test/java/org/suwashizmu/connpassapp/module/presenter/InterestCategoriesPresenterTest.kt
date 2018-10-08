package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.usecase.InterestCategoriesGetUseCase
import org.suwashizmu.connpassapp.module.usecase.InterestCategorySelectUseCase

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategoriesPresenterTest {

    private val getUseCase: InterestCategoriesGetUseCase = mock()
    private val selectUseCase: InterestCategorySelectUseCase = mock()

    private val presenter = InterestCategoriesPresenter()
    private val subject: InterestCategoriesSubject = mock()

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
    fun completeEntry() {
        //subjectのTest
        presenter.completeEntry(InterestCategory.AI, InterestCategory.C_SHAPE)

        verify(subject).update(any())
    }
}