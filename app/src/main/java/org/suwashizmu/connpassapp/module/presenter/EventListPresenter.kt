package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.IEventListController
import org.suwashizmu.connpassapp.module.input.EventFetchInputData
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.router.IEventListRouter
import org.suwashizmu.connpassapp.module.usecase.IEventFetchUseCase
import org.suwashizmu.connpassapp.module.view.EventListViewModel

/**
 * Created by KEKE
 */
class EventListPresenter : IEventListPresenter, IEventListController {

    private val viewModel = EventListViewModel(
            emptyList()
    )

    override var subject: EventListSubject = EventListSubject
    override var useCase: IEventFetchUseCase? = null
    override var router: IEventListRouter? = null

    private val pagination: EventFetchInputData = EventFetchInputData(0, 30)

    override fun onCreate() {
        useCase?.fetchEvent(pagination)
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {

        useCase = null
        router = null
    }

    override fun complete(eventList: EventSearchOutputData) {

        //TODO Mapperが必要
        viewModel.eventList = eventList.eventList.map { EventListViewModel.Event(it.title, it.catch) }
        subject.update(viewModel)
    }

    //region IEventListController
    override fun onPullRefresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }
    //endregion IEventListController
}