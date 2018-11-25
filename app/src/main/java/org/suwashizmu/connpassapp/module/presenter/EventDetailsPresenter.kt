package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.output.EventDetailsOutputData
import org.suwashizmu.connpassapp.module.router.IEventDetailsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSingleEventUseCase
import org.suwashizmu.connpassapp.module.view.EventDetailsViewModel

/**
 * Created by KEKE
 */
class EventDetailsPresenter : IEventDetailsPresenter {

    override var useCase: IFetchSingleEventUseCase? = null
    override var router: IEventDetailsRouter? = null

    private var viewModel = EventDetailsViewModel(
            "",
            "",
            null
    )

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

    override fun complete(outputData: EventDetailsOutputData?, error: Throwable?) {
        if (error != null) {
            viewModel.error = error
        } else if (outputData != null) {
            viewModel.title = outputData.title
            viewModel.eventUrl = outputData.url
            viewModel.error = null
        }

        EventDetailsSubject.update(viewModel)
    }
}