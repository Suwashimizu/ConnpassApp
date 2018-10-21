package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.router.ISearchSettingsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSettingsUseCase
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE on 2018/10/21.
 */
class SearchSettingsPresenterTest {

    private val fetcher: IFetchSettingsUseCase = mock()
    private val mockRouter: ISearchSettingsRouter = mock()

    private val presenter = SearchSettingsPresenter().apply {
        this.fetchSettingsUseCase = fetcher
        router = mockRouter
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
    fun `onNavigationButtonClick`() {
        presenter.onNavigationButtonClick()

        verify(mockRouter).close()
    }

    @Test
    fun loadSettings() {
        presenter.loadSettings()

        verify(fetcher).fetchSettings()
    }

    @Test
    fun saveSettings() {
    }

    @Test
    fun complete() {

        val test = presenter.subject.observable.test()

        presenter.complete(Area.TOKYO, listOf(InterestCategory.AI))

        test.assertNoErrors()
        assertThat(test.values().first()).isEqualTo(SearchSettingsViewModel(Area.TOKYO, listOf(InterestCategory.AI)))
    }
}