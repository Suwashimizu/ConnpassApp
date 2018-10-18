package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.output.SettingsOutputPort
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/18.
 */
class FetchSettingsInteractor(private val settingsOutputPort: SettingsOutputPort,
                              private val areaRepository: AreaRepository,
                              private val interestCategoryRepository: InterestCategoryRepository) : IFetchSettingsUseCase {

    override fun fetchSettings() {
        settingsOutputPort.complete(areaRepository.getArea(), interestCategoryRepository.getCurrentInterestCategories())
    }
}