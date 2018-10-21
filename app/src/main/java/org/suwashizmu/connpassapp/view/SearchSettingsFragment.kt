package org.suwashizmu.connpassapp.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.SearchSettingsFragBinding
import org.suwashizmu.connpassapp.module.view.ISearchSettingsView
import org.suwashizmu.connpassapp.module.presenter.ISearchSettingsPresenter

class SearchSettingsFragment : Fragment(), ISearchSettingsView {

    companion object {
        fun newInstance(): SearchSettingsFragment = SearchSettingsFragment()
    }

    private lateinit var binding: SearchSettingsFragBinding
    override var presenter: ISearchSettingsPresenter? = null
    //ViewModelの変化を監視
    private val disposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.search_settings_frag, container, false)

        //setup onClickListener

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        /*
        subject.observable
                .subscribe(this::update)
                .addTo(disposable)
        */
    }

    override fun onPause() {
        super.onPause()

        disposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()

        presenter = null
    }
}
