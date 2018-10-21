package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.router.ISearchSettingsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSettingsUseCase
import org.suwashizmu.connpassapp.module.usecase.ISaveSettingsUseCase

/**
 * Created by KEKE
 * UIロジック,Controller,outputを受け取る
 */
interface ISearchSettingsPresenter : BasePresenter {

    //subject
    var saveUseCase: ISaveSettingsUseCase?
    var fetchSettingsUseCase: IFetchSettingsUseCase?
    var router: ISearchSettingsRouter?
}