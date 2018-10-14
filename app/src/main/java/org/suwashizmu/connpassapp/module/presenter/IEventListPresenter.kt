package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.router.IEventListRouter

/**
 * Created by KEKE
 * UIロジック,Controller,outputを受け取る
 */
interface IEventListPresenter : BasePresenter {

    //subject
    //var useCase: IEventListUseCase?
    var router: IEventListRouter?

    fun complete(eventList: EventSearchOutputData)
}