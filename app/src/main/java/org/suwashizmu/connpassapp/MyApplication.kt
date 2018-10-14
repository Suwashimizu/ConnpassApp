package org.suwashizmu.connpassapp

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository
import org.suwashizmu.connpassapp.module.repository.local.LocalAreaRepository
import org.suwashizmu.connpassapp.module.repository.local.LocalInterestCategoryRepository
import org.suwashizmu.connpassapp.module.repository.remote.RemoteEventDataSource
import org.suwashizmu.connpassapp.service.api.ConnpassClient

/**
 * Created by KEKE on 2018/10/07.
 */
class MyApplication : Application(), KodeinAware {

    //DIの定義を行う
    override val kodein: Kodein
        get() = Kodein.lazy {
            //binding処理を記入,RepositoryはSingletonで渡す
            bind<AreaRepository>() with singleton { LocalAreaRepository(this@MyApplication) }
            bind<InterestCategoryRepository>() with singleton { LocalInterestCategoryRepository(this@MyApplication) }
            bind<EventRepository>() with singleton { RemoteEventDataSource(ConnpassClient.service) }
        }

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}