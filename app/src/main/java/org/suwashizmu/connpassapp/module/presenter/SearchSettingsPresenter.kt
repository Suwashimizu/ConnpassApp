package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.input.SaveSettingsInputData
import org.suwashizmu.connpassapp.module.router.ISearchSettingsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSettingsUseCase
import org.suwashizmu.connpassapp.module.usecase.ISaveSettingsUseCase
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE
 */
class SearchSettingsPresenter : ISearchSettingsPresenter {

    override var subject: SearchSettingsSubject = SearchSettingsSubject
    override var saveUseCase: ISaveSettingsUseCase? = null
    override var fetchSettingsUseCase: IFetchSettingsUseCase? = null
    override var router: ISearchSettingsRouter? = null

    override var viewModel = SearchSettingsViewModel()

    override fun onCreate() {
        loadSettings()
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {

        saveUseCase = null
        fetchSettingsUseCase = null
        router = null
    }

    //region ISearchSettingsController

    override fun onNavigationButtonClick() {
        router?.close()
    }

    override fun loadSettings() {
        fetchSettingsUseCase?.fetchSettings()
    }

    override fun saveSettings(area: Area, vararg interestCategories: InterestCategory) {
        saveUseCase?.save(SaveSettingsInputData(area, interestCategories.toList()))
    }
    //endregion ISearchSettingsController

    //region SearchSettingsOutputPort
    override fun complete(error: Throwable?) {
        viewModel.error = error
        if (error == null) {
            router?.close()
        }
    }
    //endregion SearchSettingsOutputPort

    //region SettingsOutputPort
    override fun complete(currentArea: Area?, currentInterestCategories: Collection<InterestCategory>?, areaSource: Collection<Area>, interestCategoriesSource: Collection<InterestCategory>) {
        viewModel.area = currentArea
        if (currentInterestCategories != null) viewModel.interestCategories = currentInterestCategories

        viewModel.areaSource = areaSource
        viewModel.interestCategoriesSource = interestCategoriesSource

        subject.update(viewModel)
    }
    //endregion SettingsOutputPort
}