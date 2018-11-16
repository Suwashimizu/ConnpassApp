package org.suwashizmu.connpassapp.module.router

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

    var fragment: androidx.fragment.app.Fragment? = null

    override fun gotoSearchSettings() {

        if (fragment?.isAdded == false) return

        val (fragment, activity) = Pair(fragment!!, fragment!!.requireActivity() as EventListActivity)

        val searchSettingsFragment = SearchSettingsFragment.newInstance()

        fragment.requireFragmentManager().beginTransaction()
                //googleNewのアニメを参考
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out_down)
                .replace(R.id.container, searchSettingsFragment, TAG_SEARCH_SETTINGS)
                .addToBackStack(null)
                .commit()

        SearchSettingsAssembler().assembleSearchSettings(activity, searchSettingsFragment)
    }

}