package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/18.
 */
class FetchSettingsInteractor(private val areaRepository: AreaRepository,
                              private val interestCategoryRepository: InterestCategoryRepository) : IFetchSettings {

    override fun fetchSettings() {
        areaRepository.getArea()
        interestCategoryRepository.getCurrentInterestCategories()
    }
}