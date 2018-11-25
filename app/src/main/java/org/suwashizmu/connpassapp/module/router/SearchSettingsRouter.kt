package org.suwashizmu.connpassapp.module.router

import androidx.fragment.app.Fragment
import org.suwashizmu.connpassapp.view.EventListActivity
import org.suwashizmu.connpassapp.view.EventListFragment

/**
 * Created by KEKE
 */

class SearchSettingsRouter : ISearchSettingsRouter {

    var fragment: Fragment? = null

    override fun gotoNewEventList() {
        //list画面をクリアする
        val eventList = fragment?.fragmentManager?.findFragmentByTag(EventListActivity.TAG_EVENT_LIST) as EventListFragment
        eventList.presenter?.onRefresh()

        close()
    }

    override fun close() {
        fragment?.fragmentManager
                ?.popBackStack()
    }
}