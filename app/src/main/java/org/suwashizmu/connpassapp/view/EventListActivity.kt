package org.suwashizmu.connpassapp.view;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.assemble.EventListAssembler
import org.suwashizmu.connpassapp.module.assemble.SearchSettingsAssembler
import org.suwashizmu.connpassapp.module.router.EventListRouter

class EventListActivity : AppCompatActivity(), KodeinAware {

    companion object {

        private const val TAG_EVENT_LIST = "eventList"
        private const val TAG_SEARCH_SETTINGS = EventListRouter.TAG_SEARCH_SETTINGS

        fun newIntent(context: Context): Intent = Intent(context, EventListActivity::class.java)
    }

    private val _parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(_parentKodein)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_list_act)

        setSupportActionBar(findViewById(R.id.toolbar))

        val fragment = if (savedInstanceState == null) {
            EventListFragment.newInstance().apply {
                supportFragmentManager.beginTransaction().add(R.id.container, this, TAG_EVENT_LIST).commit()
            }
        } else {
            supportFragmentManager.findFragmentByTag(TAG_EVENT_LIST) as EventListFragment
        }

        EventListAssembler().assembleEventList(this, fragment)


        if (supportFragmentManager.findFragmentByTag(TAG_SEARCH_SETTINGS) != null) {
            SearchSettingsAssembler().assembleSearchSettings(this,
                    supportFragmentManager.findFragmentByTag(TAG_SEARCH_SETTINGS) as SearchSettingsFragment)
        }
    }
}
