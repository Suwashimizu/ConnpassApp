package org.suwashizmu.connpassapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.presenter.AreaSelectPresenter
import org.suwashizmu.connpassapp.module.repository.local.LocalAreaRepository
import org.suwashizmu.connpassapp.module.usecase.AreaSelectInteractor
import org.suwashizmu.connpassapp.module.view.ISearchEventView
import org.suwashizmu.connpassapp.module.view.SearchEventViewModel


open class MainActivity : AppCompatActivity(), ISearchEventView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.addLogAdapter(AndroidLogAdapter())

        if (savedInstanceState == null) {
            /*
            val eventSearchController = EventSearchController(EventSearchInteractor(
                    RemoteEventDataSource(ConnpassClient.service),
                    EventSearchPresenter(this)
            ))

            eventSearchController.eventSearch("kotlin")
            */

            val fragment = WizardFragment.newInstance()
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, fragment)
                    .commit()

            val presenter = AreaSelectPresenter().apply {
                useCase = AreaSelectInteractor(this, LocalAreaRepository(this@MainActivity))
            }
            fragment.presenter = presenter
        }

    }

    override fun updated(viewModel: SearchEventViewModel) {
        Logger.d("updated!")
    }
}
