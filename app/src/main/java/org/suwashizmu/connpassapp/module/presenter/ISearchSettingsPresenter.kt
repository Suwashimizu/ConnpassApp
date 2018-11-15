package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.ISearchSettingsController
import org.suwashizmu.connpassapp.module.output.SearchSettingsOutputPort
import org.suwashizmu.connpassapp.module.output.SettingsOutputPort
import org.suwashizmu.connpassapp.module.router.ISearchSettingsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSettingsUseCase
import org.suwashizmu.connpassapp.module.usecase.ISaveSettingsUseCase
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE
 * UIロジック,Controller,outputを受け取る
 */
interface ISearchSettingsPresenter : BasePresenter, ISearchSettingsController, SearchSettingsOutputPort, SettingsOutputPort {

    var subject: SearchSettingsSubject
    var saveUseCase: ISaveSettingsUseCase?
    var fetchSettingsUseCase: IFetchSettingsUseCase?
    var router: ISearchSettingsRouter?

    var viewModel: SearchSettingsViewModel
}