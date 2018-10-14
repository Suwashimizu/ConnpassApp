package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.IEventListController
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

        useCase = null
        router = null
    }

    override fun complete(eventList: EventSearchOutputData) {

        //TODO Mapperが必要
        viewModel.eventList = eventList.eventList.map { EventListViewModel.Event(it.title) }
        subject.update(viewModel)
    }

}