package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.input.InterestCategoryInputData
import org.suwashizmu.connpassapp.module.usecase.InterestCategoriesGetUseCase
import org.suwashizmu.connpassapp.module.usecase.InterestCategorySelectUseCase
import org.suwashizmu.connpassapp.module.view.InterestCategoriesViewModel

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategoriesPresenter : IInterestCategoriesPresenter {

    private val viewModel = InterestCategoriesViewModel()

    override var selectUseCase: InterestCategorySelectUseCase? = null
    override var getUseCase: InterestCategoriesGetUseCase? = null
    override var subject: InterestCategoriesSubject = InterestCategoriesSubject

    override fun fetchInterestCategories() {
        getUseCase?.getInterestCategories()
    }

    override fun onClickNextButton(vararg interestCategory: InterestCategory) {
        val inputData = InterestCategoryInputData(interestCategory.toSet())
        selectUseCase?.select(inputData)
    }


    override fun completeInterestCategories(list: Collection<InterestCategory>) {

        viewModel.interestCategories = list

        subject.update(viewModel)

    }

    override fun completeEntry(vararg interestCategory: InterestCategory) {

        viewModel.selectCategories = interestCategory.toList()

        subject.update(viewModel)
    }

}