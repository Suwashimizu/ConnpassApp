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
            mutableListOf(),
            hasNextEvents = false,
            refreshing = false
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
        viewModel.eventList.addAll(eventList.eventList.map { EventListViewModel.Event(it.title, it.catch) })
        viewModel.hasNextEvents = eventList.hasNext()
        viewModel.refreshing = false

        subject.update(viewModel)
    }

    //region IEventListController
    override fun onPullRefresh() {
        //キャッシュの削除,offsetを元に戻す
        viewModel.eventList.clear()
        viewModel.hasNextEvents = true
        pagination.refresh()

        useCase?.fetchEvent(pagination)
    }

    override fun onScrollEnd() {
        pagination.next()
        useCase?.fetchEvent(pagination)
    }

    //endregion IEventListController
}