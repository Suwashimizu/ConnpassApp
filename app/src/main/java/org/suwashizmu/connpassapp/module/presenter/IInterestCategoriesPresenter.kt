package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.IInterestCategoriesController
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.output.InterestCateoriesOutput
import org.suwashizmu.connpassapp.module.router.IWizardRouter
import org.suwashizmu.connpassapp.module.usecase.InterestCategoriesGetUseCase
import org.suwashizmu.connpassapp.module.usecase.InterestCategorySelectUseCase

/**
 * Created by KEKE on 2018/10/08.
 * controllerも兼ねる
 */
interface IInterestCategoriesPresenter : BasePresenter, IInterestCategoriesController {

    var selectUseCase: InterestCategorySelectUseCase?
    var getUseCase: InterestCategoriesGetUseCase?
    var subject: InterestCategoriesSubject
    var router: IWizardRouter?

    fun completeInterestCategories(list: Collection<InterestCategory>)

    fun completeEntry(output: InterestCateoriesOutput)
}