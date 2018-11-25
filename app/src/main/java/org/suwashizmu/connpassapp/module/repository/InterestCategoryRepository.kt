package org.suwashizmu.connpassapp.module.repository

import io.reactivex.Completable
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
interface InterestCategoryRepository {
    fun getInterestCategories(): Collection<InterestCategory>
    /**
     * @throws IllegalStateException throws it exception when interestCategory args is empty
     */
    fun save(vararg interestCategory: InterestCategory): Completable

    fun getCurrentInterestCategories(): Collection<InterestCategory>?
}