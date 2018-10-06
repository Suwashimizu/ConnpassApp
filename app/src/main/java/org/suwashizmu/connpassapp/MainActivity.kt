package org.suwashizmu.connpassapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.suwashizmu.connpassapp.module.controller.AreaSelectController
import org.suwashizmu.connpassapp.module.controller.EventSearchController
import org.suwashizmu.connpassapp.module.presenter.AreaSelectPresenter
import org.suwashizmu.connpassapp.module.presenter.EventSearchPresenter
import org.suwashizmu.connpassapp.module.repository.LocalAreaRepository
import org.suwashizmu.connpassapp.module.repository.RemoteEventDataSource
import org.suwashizmu.connpassapp.module.usecase.AreaSelectInteractor
import org.suwashizmu.connpassapp.module.usecase.EventSearchInteractor
import org.suwashizmu.connpassapp.module.view.AreaSelectViewModel
import org.suwashizmu.connpassapp.module.view.IAreaSelectView
import org.suwashizmu.connpassapp.module.view.ISearchEventView
import org.suwashizmu.connpassapp.module.view.SearchEventViewModel
import org.suwashizmu.connpassapp.service.api.ConnpassClient


open class MainActivity : AppCompatActivity(), ISearchEventView, IAreaSelectView {

    override fun onCreate(savedInstanceState: Bundle?) {

        Logger.addLogAdapter(AndroidLogAdapter())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eventSearchController = EventSearchController(EventSearchInteractor(
                RemoteEventDataSource(ConnpassClient.service),
                EventSearchPresenter(this)
        ))

        eventSearchController.eventSearch("kotlin")

        val areaSelectController = AreaSelectController(AreaSelectInteractor(
                AreaSelectPresenter(this),
                LocalAreaRepository(this)
        ))

        areaSelectController.fetchAreaList()
    }

    override fun updated(viewModel: SearchEventViewModel) {
        Logger.d("updated!")
    }

    override fun update(viewModel: AreaSelectViewModel) {
        Logger.d("updated!")
    }
}
