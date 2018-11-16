package org.suwashizmu.connpassapp.view;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.assemble.EventDetailsAssembler

class EventDetailsActivity : AppCompatActivity(), KodeinAware {

    companion object {
        fun newIntent(context: Context, eventId: Int): Intent = Intent(context, EventDetailsActivity::class.java)
    }

    private val _parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(_parentKodein)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_details_act)

        val fragment = if (savedInstanceState == null) {
            EventDetailsFragment.newInstance().apply {
                supportFragmentManager.beginTransaction().add(R.id.container, this).commit()
            }
        } else {
            supportFragmentManager.findFragmentById(R.id.container) as EventDetailsFragment
        }

        EventDetailsAssembler().assembleEventDetails(this, fragment)
    }
}
