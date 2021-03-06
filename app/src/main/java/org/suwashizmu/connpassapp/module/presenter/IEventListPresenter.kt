package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.IEventListController
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.router.IEventListRouter
import org.suwashizmu.connpassapp.module.usecase.IEventFetchUseCase

/**
 * Created by KEKE
 * UIロジック,Controller,outputを受け取る
 */
interface IEventListPresenter : BasePresenter, IEventListController {

    var subject: EventListSubject
    var useCase: IEventFetchUseCase?
    var router: IEventListRouter?

    fun onRefresh()

    fun complete(eventList: EventSearchOutputData)
}