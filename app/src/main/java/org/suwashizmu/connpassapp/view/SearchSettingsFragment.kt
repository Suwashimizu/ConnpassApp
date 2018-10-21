package org.suwashizmu.connpassapp.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.SearchSettingsFragBinding
import org.suwashizmu.connpassapp.module.presenter.ISearchSettingsPresenter
import org.suwashizmu.connpassapp.module.presenter.SearchSettingsSubject
import org.suwashizmu.connpassapp.module.view.ISearchSettingsView
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel
import org.suwashizmu.connpassapp.view.adapter.SearchSettingsAdapter

class SearchSettingsFragment : Fragment(), ISearchSettingsView {

    companion object {
        fun newInstance(): SearchSettingsFragment = SearchSettingsFragment()
    }

    private lateinit var binding: SearchSettingsFragBinding
    override var presenter: ISearchSettingsPresenter? = null
    //ViewModelの変化を監視
    private val disposable = CompositeDisposable()
    private val subject: SearchSettingsSubject = SearchSettingsSubject

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.search_settings_frag, container, false)

        //setup onClickListener
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        requireActivity().findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener(navigationListener)

        binding.listView.adapter = SearchSettingsAdapter()
        binding.listView.layoutManager = LinearLayoutManager(requireActivity())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter?.onCreate()
    }

    override fun onResume() {
        super.onResume()

        subject.observable
                .subscribe(this::update)
                .addTo(disposable)

    }

    override fun onPause() {
        super.onPause()

        presenter?.onPause()
        disposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()

        presenter = null
    }

    override fun update(searchSettingsViewModel: SearchSettingsViewModel) {
        Logger.d(searchSettingsViewModel)

        val adapter = binding.listView.adapter as? SearchSettingsAdapter ?: return

        adapter.viewModel = searchSettingsViewModel
        adapter.notifyDataSetChanged()
    }

    private val navigationListener: View.OnClickListener = View.OnClickListener {
        presenter?.onNavigationButtonClick()
    }
}
