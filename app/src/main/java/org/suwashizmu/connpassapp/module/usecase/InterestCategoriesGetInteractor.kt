package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.presenter.IInterestCategoriesPresenter
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategoriesGetInteractor(
        private val presenter: IInterestCategoriesPresenter,
        private val repository: InterestCategoryRepository) : InterestCategoriesGetUseCase {

    override fun getInterestCategories() =
            presenter.completeInterestCategories(repository.getInterestCategories())
}