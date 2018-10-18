package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.input.AreaSelectInputData
import org.suwashizmu.connpassapp.module.router.IWizardRouter
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase
import org.suwashizmu.connpassapp.module.view.AreaSelectViewModel

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectPresenter : IAreaSelectPresenter {

    override var subject: AreaSelectSubject? = null

    override var useCase: IAreaSelectUseCase? = null

    override var router: IWizardRouter? = null

    private val viewModel = AreaSelectViewModel()

    //region IAreaSelectPresenter
    override fun onCreate() {

    }

    override fun onResume() {

    }

    override fun onPause() {
    }

    override fun onDestroy() {
        subject = null
        useCase = null
        router = null
    }
    //endregion IAreaSelectPresenter

    override fun fetchAreaList() {
        useCase?.getAreaList()
    }

    override fun onNextButtonClick(area: Area) {
        useCase?.select(AreaSelectInputData(area))
    }

    override fun completeAreaList(list: Collection<Area>) {

        viewModel.areaList = list
        subject?.update(viewModel)
    }

    override fun completeSelected(area: Area) {

        viewModel.selectedArea = area
        subject?.update(viewModel)

        router?.gotoInterestSelect()
    }

    //region SettingsOutputPort
    override fun complete(area: Area?, interestCategories: Collection<InterestCategory>?) {
        if (area != null && interestCategories != null) {
            router?.gotoEventList()
        }
    }
    //endregion SettingsOutputPort
}