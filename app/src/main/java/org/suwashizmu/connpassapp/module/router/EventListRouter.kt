package org.suwashizmu.connpassapp.module.router

import android.support.v4.app.Fragment
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.view.SearchSettingsFragment

/**
 * Created by KEKE
 */

class EventListRouter : IEventListRouter {

    var fragment: Fragment? = null

    override fun gotoSearchSettings() {

        val searchSettingsFragment = SearchSettingsFragment.newInstance()

        fragment?.fragmentManager?.beginTransaction()
                ?.replace(R.id.container, searchSettingsFragment)
                ?.addToBackStack(null)
                ?.commit()
    }

}