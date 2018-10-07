package org.suwashizmu.connpassapp

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.local.LocalAreaRepository

/**
 * Created by KEKE on 2018/10/07.
 */
class MyApplication : Application(), KodeinAware {

    //DIの定義を行う
    override val kodein: Kodein
        get() = Kodein.lazy {
            //binding処理を記入,RepositoryはSingletonで渡す
            bind<AreaRepository>() with singleton { LocalAreaRepository(this@MyApplication) }
        }

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}