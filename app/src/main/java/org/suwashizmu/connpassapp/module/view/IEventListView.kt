package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.presenter.IEventListPresenter

/**
 * Created by KEKE
 */
interface IEventListView {

    var presenter: IEventListPresenter?

    fun update(viewModel: EventListViewModel)

}