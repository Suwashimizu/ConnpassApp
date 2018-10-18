package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/18.
 */
class FetchSettingsUseCaseTest {

    private val mockAreaRepository: AreaRepository = mock()
    private val mockInterestCategoryRepository: InterestCategoryRepository = mock()

    private val interactor = FetchSettingsInteractor(mockAreaRepository, mockInterestCategoryRepository)

    @Test
    fun fetchSettings() {
        interactor.fetchSettings()

        verify(mockAreaRepository).getArea()
        verify(mockInterestCategoryRepository).getCurrentInterestCategories()
    }
}