package org.suwashizmu.connpassapp.module.repository

import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
interface InterestCategoryRepository {
    fun getInterestCategories(): Collection<InterestCategory>
    fun save(vararg interestCategory: InterestCategory)
    fun getCurrentInterestCategories(): Collection<InterestCategory>?
}