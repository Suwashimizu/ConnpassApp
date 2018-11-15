package org.suwashizmu.connpassapp.module.router

import android.support.v4.app.Fragment

/**
 * Created by KEKE
 */

class SearchSettingsRouter : ISearchSettingsRouter {

    var fragment: Fragment? = null

    override fun close() {
        fragment?.fragmentManager
                ?.popBackStack()
    }
}