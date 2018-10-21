package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.entity.Settings
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE
 */
class SaveSettingsInteractor(private val areaRepository: AreaRepository,
                             private val interestCategoryRepository: InterestCategoryRepository) : ISaveSettingsUseCase {

    override fun save(settings: Settings) {
        areaRepository.save(settings.area)
        interestCategoryRepository.save(*settings.interestCategory.toTypedArray())
    }
}