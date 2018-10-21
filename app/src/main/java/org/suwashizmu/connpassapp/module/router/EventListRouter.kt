package org.suwashizmu.connpassapp.module.router

import android.support.v4.app.Fragment
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.assemble.SearchSettingsAssembler
import org.suwashizmu.connpassapp.view.EventListActivity
import org.suwashizmu.connpassapp.view.SearchSettingsFragment

/**
 * Created by KEKE
 */

class EventListRouter : IEventListRouter {

    companion object {
        const val TAG_SEARCH_SETTINGS = "settings"
    }

    var fragment: Fragment? = null

    override fun gotoSearchSettings() {

        if (fragment?.isAdded == false) return

        val (fragment, activity) = Pair(fragment!!, fragment!!.requireActivity() as EventListActivity)

        val searchSettingsFragment = SearchSettingsFragment.newInstance()

        fragment.requireFragmentManager().beginTransaction()
                .replace(R.id.container, searchSettingsFragment, TAG_SEARCH_SETTINGS)
                .addToBackStack(null)
                .commit()

        SearchSettingsAssembler().assembleSearchSettings(activity, searchSettingsFragment)
    }

}