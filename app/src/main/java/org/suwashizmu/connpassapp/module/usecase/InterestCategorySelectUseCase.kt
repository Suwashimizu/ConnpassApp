package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.input.InterestCategoryInputData

/**
 * Created by KEKE on 2018/10/08.
 */
interface InterestCategorySelectUseCase {

    fun select(inputData: InterestCategoryInputData)
}