package org.suwashizmu.connpassapp.module.router

/**
 * Created by KEKE
 */

class SearchSettingsRouter : ISearchSettingsRouter {

    var fragment: androidx.fragment.app.Fragment? = null

    override fun close() {
        fragment?.fragmentManager
                ?.popBackStack()
    }
}