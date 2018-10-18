package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.output.SettingsOutputPort
import org.suwashizmu.connpassapp.module.router.IWizardRouter
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase

/**
 * Created by KEKE on 2018/10/06.
 */
interface IAreaSelectPresenter : BasePresenter, SettingsOutputPort {

    var subject: AreaSelectSubject?
    var useCase: IAreaSelectUseCase?
    var router: IWizardRouter?

    fun fetchAreaList()

    fun onNextButtonClick(area: Area)

    fun completeAreaList(list: Collection<Area>)

    fun completeSelected(area: Area)
}