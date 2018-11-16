package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.router.IEventDetailsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSingleEventUseCase

/**
 * Created by KEKE
 */
class EventDetailsPresenter : IEventDetailsPresenter {

    override var useCase: IFetchSingleEventUseCase? = null
    override var router: IEventDetailsRouter? = null

    override fun onCreate() {

    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {
    }

    //region IEventDetailsController
    override fun getEvent(id: Int) {
        useCase?.fetchEvent(id)
    }
    //endregion IEventDetailsController
}