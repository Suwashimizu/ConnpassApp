package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.router.ISearchSettingsRouter

/**
 * Created by KEKE
 * UIロジック,Controller,outputを受け取る
 */
interface ISearchSettingsPresenter : BasePresenter {

    //subject
    //var useCase: ISearchSettingsUseCase?
    var router: ISearchSettingsRouter?
}