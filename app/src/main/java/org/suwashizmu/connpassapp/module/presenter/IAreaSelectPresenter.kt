package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase
import org.suwashizmu.connpassapp.module.view.IAreaSelectView

/**
 * Created by KEKE on 2018/10/06.
 */
interface IAreaSelectPresenter {

    var view: IAreaSelectView
    var useCase: IAreaSelectUseCase

    fun fetchAreaList()

    fun onNextButtonClick(area: Area)

    fun completeAreaList(list: Collection<Area>)

    fun completeSelected(area: Area)
}