package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.input.InterestCategoryInputData
import org.suwashizmu.connpassapp.module.output.InterestCateoriesOutput
import org.suwashizmu.connpassapp.module.presenter.IInterestCategoriesPresenter
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategorySelectInteractor(
        private val presenter: IInterestCategoriesPresenter,
        private val repository: InterestCategoryRepository) : InterestCategorySelectUseCase {

    override fun select(inputData: InterestCategoryInputData) {
        try {
            repository.save(*inputData.interestCategory.toTypedArray())
            presenter.completeEntry(InterestCateoriesOutput(inputData.interestCategory, true))
        } catch (e: Throwable) {
            e.printStackTrace()
            presenter.completeEntry(InterestCateoriesOutput(inputData.interestCategory, false))
        }
    }
}