package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.IEventListController
import org.suwashizmu.connpassapp.module.input.EventFetchInputData
import org.suwashizmu.connpassapp.module.mapper.EventItemMapper
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
            refreshing = false,
            loading = true,
            error = null
    )

    override var subject: EventListSubject = EventListSubject
    override var useCase: IEventFetchUseCase? = null
    override var router: IEventListRouter? = null

    private val pagination: EventFetchInputData = EventFetchInputData(0, 30)

    private val mapper = EventItemMapper()

    override fun onCreate() {

        viewModel.loading = true
        subject.update(viewModel)

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

    override fun onRefresh() {

        viewModel.eventList.clear()

        subject.update(viewModel)
    }

    override fun complete(eventList: EventSearchOutputData) {

        if (eventList.error == null) {
            viewModel.eventList.addAll(eventList.eventList.map { mapper.toEvent(it) })
            //全件より少なければ未取得のEventがある
            viewModel.hasNextEvents = viewModel.eventList.size < eventList.totalEventCount

            pagination.next()
        }

        viewModel.error = eventList.error
        viewModel.refreshing = false
        viewModel.loading = false

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
        useCase?.fetchEvent(pagination)
    }

    override fun onSearchIconClicked() {
        router?.gotoSearchSettings()
    }

    override fun onItemClick(event: EventListViewModel.Event) {
        router?.gotoEventDetails(event.id, event.title, event.eventUrl)
    }
    //endregion IEventListController
}