package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.router.IEventListRouter
import org.suwashizmu.connpassapp.module.usecase.IEventSearchUseCase

/**
 * Created by KEKE
 * UIロジック,Controller,outputを受け取る
 */
interface IEventListPresenter : BasePresenter {

    //subject
    var useCase: IEventSearchUseCase?
    var router: IEventListRouter?

    fun complete(eventList: EventSearchOutputData)
}