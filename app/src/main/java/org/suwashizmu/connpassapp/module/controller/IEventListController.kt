package org.suwashizmu.connpassapp.module.controller

/**
 * Created by KEKE
 * アクションを定義する
 */
interface IEventListController {

    fun onScrollEnd()

    fun onPullRefresh()

    fun onSearchIconClicked()
}