package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.router.IEventListRouter

/**
 * Created by KEKE
 */
class EventListPresenter : IEventListPresenter {

    //subject
    //var useCase: IEventListUseCase?
    override var router: IEventListRouter? = null

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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