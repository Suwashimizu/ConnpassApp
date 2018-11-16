package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.router.IEventDetailsRouter

/**
 * Created by KEKE
 * UIロジック,Controller,outputを受け取る
 */
interface IEventDetailsPresenter : BasePresenter {

    //subject
    //var useCase: IEventDetailsUseCase?
    var router: IEventDetailsRouter?
}