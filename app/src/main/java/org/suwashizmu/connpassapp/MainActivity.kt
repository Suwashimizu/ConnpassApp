package org.suwashizmu.connpassapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.suwashizmu.connpassapp.module.controller.EventSearchController
import org.suwashizmu.connpassapp.module.presenter.EventSearchPresenter
import org.suwashizmu.connpassapp.module.repository.RemoteEventDataSource
import org.suwashizmu.connpassapp.module.usecase.EventSearchInteractor
import org.suwashizmu.connpassapp.module.view.ISearchEventView
import org.suwashizmu.connpassapp.module.view.SearchEventViewModel
import org.suwashizmu.connpassapp.service.api.ConnpassClient


class MainActivity : AppCompatActivity(), ISearchEventView {

    override fun onCreate(savedInstanceState: Bundle?) {

        Logger.addLogAdapter(AndroidLogAdapter())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = EventSearchController(EventSearchInteractor(
                RemoteEventDataSource(ConnpassClient.service),
                EventSearchPresenter(this)
        ))

        controller.eventSearch("kotlin")
    }

    override fun updated(viewModel: SearchEventViewModel) {
        Logger.d("updated!")
    }
}
