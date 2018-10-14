package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.IEventListController
import org.suwashizmu.connpassapp.module.input.EventSearchInputData
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.router.IEventListRouter
import org.suwashizmu.connpassapp.module.usecase.IEventSearchUseCase

/**
 * Created by KEKE
 */
class EventListPresenter : IEventListPresenter, IEventListController {

    //subject
    //var useCase: IEventListUseCase?
    override var useCase: IEventSearchUseCase? = null
    override var router: IEventListRouter? = null

    override fun onCreate() {
        useCase?.search(EventSearchInputData(emptySet(), 200))
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun complete(eventList: EventSearchOutputData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}