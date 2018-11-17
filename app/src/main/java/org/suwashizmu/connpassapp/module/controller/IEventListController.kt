package org.suwashizmu.connpassapp.module.controller

import org.suwashizmu.connpassapp.module.view.EventListViewModel

/**
 * Created by KEKE
 * アクションを定義する
 */
interface IEventListController {

    fun onScrollEnd()

    fun onPullRefresh()

    fun onSearchIconClicked()

    /**
     * リストのItemをクリックした時
     */
    fun onItemClick(event: EventListViewModel.Event)
}