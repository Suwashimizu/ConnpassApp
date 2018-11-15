package org.suwashizmu.connpassapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.assemble.WizardAssembler
import org.suwashizmu.connpassapp.module.view.ISearchEventView
import org.suwashizmu.connpassapp.module.view.SearchEventViewModel


open class MainActivity : AppCompatActivity(), KodeinAware, ISearchEventView {

    private val _parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(_parentKodein)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))


        if (savedInstanceState == null) {
            /*
            val eventSearchController = EventSearchController(EventSearchInteractor(
                    RemoteEventDataSource(ConnpassClient.service),
                    EventSearchPresenter(this)
            ))

            eventSearchController.eventSearch("kotlin")
            */

            //assembleFragmentでfind出来るようにするためcommitNowを使うこと!
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, WizardFragment.newInstance(), WizardAssembler.TAG_FRAGMENT)
                    .commitNow()
        }

        //CleanArchitectureで使用するPresenter,Repository,Interactorなどの構築を行う
        WizardAssembler().assembleFragment(this)
    }

    override fun updated(viewModel: SearchEventViewModel) {
        Logger.d("updated!")
    }

    fun assembleWizardInterestFragment(fragment: WizardInterestFragment) {
        WizardAssembler().assembleInterestCategories(this, fragment)
    }
}
