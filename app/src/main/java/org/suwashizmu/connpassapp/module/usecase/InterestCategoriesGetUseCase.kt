package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
interface InterestCategoriesGetUseCase {

    fun getInterestCategories(): Collection<InterestCategory>
}