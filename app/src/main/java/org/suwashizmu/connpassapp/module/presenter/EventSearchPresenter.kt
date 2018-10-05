package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.view.SearchEventViewModel

/**
 * Created by KEKE on 2018/10/05.
 */
class EventSearchPresenter : IEventSearchPresenter {

    override fun complete(outputData: EventSearchOutputData) {
        val viewModel = SearchEventViewModel(outputData.eventList.map {
            SearchEventViewModel.Event(it.title)
        })

        print(viewModel)
    }
}