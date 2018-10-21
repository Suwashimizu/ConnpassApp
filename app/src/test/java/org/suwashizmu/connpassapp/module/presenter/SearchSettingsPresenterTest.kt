package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.usecase.IFetchSettingsUseCase

/**
 * Created by KEKE on 2018/10/21.
 */
class SearchSettingsPresenterTest {

    private val fetcher: IFetchSettingsUseCase = mock()

    private val presenter = SearchSettingsPresenter().apply {
        this.fetchSettingsUseCase = fetcher
    }

    @Test
    fun onCreate() {
        presenter.onCreate()

        verify(fetcher).fetchSettings()
    }

    @Test
    fun onResume() {
    }

    @Test
    fun onPause() {
    }

    @Test
    fun onDestroy() {
    }

    @Test
    fun loadSettings() {
    }

    @Test
    fun saveSettings() {
    }

    @Test
    fun complete() {
    }
}