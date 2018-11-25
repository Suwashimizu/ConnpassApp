package org.suwashizmu.connpassapp

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository
import org.suwashizmu.connpassapp.module.repository.StubEventDataSource
import org.suwashizmu.connpassapp.module.repository.local.LocalAreaRepository
import org.suwashizmu.connpassapp.module.repository.local.LocalInterestCategoryRepository
import org.suwashizmu.connpassapp.module.repository.remote.EventDataSource
import org.suwashizmu.connpassapp.module.repository.remote.LocalEventDataSource
import org.suwashizmu.connpassapp.module.repository.remote.RemoteEventDataSource
import org.suwashizmu.connpassapp.service.api.ConnpassClient

/**
 * Created by KEKE on 2018/10/07.
 */
class MyApplication : Application(), KodeinAware {

    //DIの定義を行う
    override val kodein = Kodein {
        //binding処理を記入,RepositoryはSingletonで渡す
        bind<AreaRepository>() with singleton { LocalAreaRepository(this@MyApplication) }
        bind<InterestCategoryRepository>() with singleton { LocalInterestCategoryRepository(this@MyApplication) }
        bind<LocalEventDataSource>() with singleton { LocalEventDataSource() }
        bind<RemoteEventDataSource>() with singleton { RemoteEventDataSource(ConnpassClient.service) }

        //TODO Stubのままリリースしないこと
        bind<EventRepository>() with singleton { EventDataSource(instance(), instance()) }
        bind<EventRepository>("singleEvent") with singleton { StubEventDataSource() }
    }

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}