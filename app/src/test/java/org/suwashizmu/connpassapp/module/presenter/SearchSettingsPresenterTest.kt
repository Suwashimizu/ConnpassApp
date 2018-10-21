package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.check
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.router.ISearchSettingsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSettingsUseCase
import org.suwashizmu.connpassapp.module.usecase.ISaveSettingsUseCase
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE on 2018/10/21.
 */
class SearchSettingsPresenterTest {

    private val fetcher: IFetchSettingsUseCase = mock()
    private val mockStore: ISaveSettingsUseCase = mock()
    private val mockRouter: ISearchSettingsRouter = mock()

    private val presenter = SearchSettingsPresenter().apply {
        this.fetchSettingsUseCase = fetcher
        saveUseCase = mockStore
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
        presenter.saveSettings(Area.FUKUSHIMA, InterestCategory.KOTLIN)

        verify(mockStore).save(check {
            assertThat(it.area).isEqualTo(Area.FUKUSHIMA)
            assertThat(it.interestCategory).contains(InterestCategory.KOTLIN)
        })
    }

    @Test
    fun complete() {

        val test = presenter.subject.observable.test()

        presenter.complete(currentArea = Area.TOKYO,
                currentInterestCategories = listOf(InterestCategory.AI),
                areaSource = listOf(Area.FUKUI),
                interestCategoriesSource = listOf(InterestCategory.KOTLIN))

        test.assertNoErrors()
        assertThat(test.values().last()).isEqualTo(SearchSettingsViewModel(Area.TOKYO, listOf(InterestCategory.AI), listOf(Area.FUKUI), listOf(InterestCategory.KOTLIN)))
    }

    @Test
    fun onAreaSelected() {

        presenter.onAreaSelected(Area.FUKUOKA)

        assertThat(presenter.viewModel.area).isEqualTo(Area.FUKUOKA)

        val test = presenter.subject.observable.test()
        assertThat(test.values().last().area).isEqualTo(Area.FUKUOKA)
    }
}