package org.suwashizmu.connpassapp.module.controller

import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
interface IInterestCategoriesController {

    fun fetchInterestCategories()

    fun onClickNextButton(vararg interestCategory: InterestCategory)
}