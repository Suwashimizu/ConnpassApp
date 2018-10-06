package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.input.AreaSelectInputData
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase
import org.suwashizmu.connpassapp.module.view.AreaSelectViewModel
import org.suwashizmu.connpassapp.module.view.IAreaSelectView

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectPresenter : IAreaSelectPresenter {

    override lateinit var view: IAreaSelectView

    override lateinit var useCase: IAreaSelectUseCase

    private val viewModel = AreaSelectViewModel()

    override fun fetchAreaList() {
        useCase.getAreaList()
    }

    override fun onNextButtonClick(area: Area) {
        useCase.select(AreaSelectInputData(area))
    }

    override fun completeAreaList(list: Collection<Area>) {

        viewModel.areaList = list

        view.update(viewModel)
    }

    override fun completeSelected(area: Area) {

        viewModel.selectedArea = area

        view.update(viewModel)
    }
}