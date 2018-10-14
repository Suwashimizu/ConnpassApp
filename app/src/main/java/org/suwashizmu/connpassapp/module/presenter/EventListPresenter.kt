package org.suwashizmu.connpassapp.module.presenter

import com.orhanobut.logger.Logger
import org.suwashizmu.connpassapp.module.controller.IEventListController
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.router.IEventListRouter
import org.suwashizmu.connpassapp.module.usecase.IEventFetchUseCase

/**
 * Created by KEKE
 */
class EventListPresenter : IEventListPresenter, IEventListController {

    //subject
    //var useCase: IEventListUseCase?
    override var useCase: IEventFetchUseCase? = null
    override var router: IEventListRouter? = null

    override fun onCreate() {
        useCase?.fetchEvent()
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
        Logger.d(eventList)
    }

}