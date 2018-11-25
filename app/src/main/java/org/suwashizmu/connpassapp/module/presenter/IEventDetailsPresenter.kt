package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.IEventDetailsController
import org.suwashizmu.connpassapp.module.output.EventDetailsOutputPort
import org.suwashizmu.connpassapp.module.router.IEventDetailsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSingleEventUseCase

/**
 * Created by KEKE
 * UIロジック,Controller,outputを受け取る
 */
interface IEventDetailsPresenter : BasePresenter, IEventDetailsController, EventDetailsOutputPort {

    //subject
    var useCase: IFetchSingleEventUseCase?
    var router: IEventDetailsRouter?
}