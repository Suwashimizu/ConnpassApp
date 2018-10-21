package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.input.SaveSettingsInputData
import org.suwashizmu.connpassapp.module.output.SearchSettingsOutputPort
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE
 */
class SaveSettingsInteractor(private val outputPort: SearchSettingsOutputPort,
                             private val areaRepository: AreaRepository,
                             private val interestCategoryRepository: InterestCategoryRepository) : ISaveSettingsUseCase {

    override fun save(inputData: SaveSettingsInputData) {

        areaRepository.save(inputData.area)
        interestCategoryRepository.save(*inputData.interestCategory.toTypedArray())

        outputPort.complete(null)

    }
}