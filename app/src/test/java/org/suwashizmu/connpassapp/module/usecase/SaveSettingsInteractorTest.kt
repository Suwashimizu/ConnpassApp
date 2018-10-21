package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.check
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.input.SaveSettingsInputData
import org.suwashizmu.connpassapp.module.output.SearchSettingsOutputPort
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/21.
 */
class SaveSettingsInteractorTest {

    private val outputPort: SearchSettingsOutputPort = mock()
    private val areaRepository: AreaRepository = mock()
    private val interestCategoryRepository: InterestCategoryRepository = mock()

    private val interactor = SaveSettingsInteractor(outputPort, areaRepository, interestCategoryRepository)

    private val inputData = SaveSettingsInputData(Area.TOKYO, listOf(InterestCategory.AI))

    @Test
    fun save() {
        interactor.save(inputData)

        verify(areaRepository).save(check {
            assertThat(it).isEqualTo(Area.TOKYO)
        })
        verify(interestCategoryRepository).save(check {
            assertThat(it).isEqualTo(InterestCategory.AI)
        })

        verify(outputPort).complete(null)
    }
}