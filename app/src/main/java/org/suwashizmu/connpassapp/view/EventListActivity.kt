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

class EventListActivity : AppCompatActivity(), KodeinAware {

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, EventListActivity::class.java)
    }

    private val _parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(_parentKodein)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_list_act)

        val fragment = if (savedInstanceState == null) {
            EventListFragment.newInstance().apply {
                supportFragmentManager.beginTransaction().add(R.id.container, this).commit()
            }
        } else {
            supportFragmentManager.findFragmentById(R.id.container) as EventListFragment
        }

        EventListAssembler().assembleEventList(this, fragment)
    }
}