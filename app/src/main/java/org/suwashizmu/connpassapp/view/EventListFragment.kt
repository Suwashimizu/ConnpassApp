package org.suwashizmu.connpassapp.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.EventListFragBinding
import org.suwashizmu.connpassapp.module.presenter.EventListSubject
import org.suwashizmu.connpassapp.module.presenter.IEventListPresenter
import org.suwashizmu.connpassapp.module.view.EventListViewModel
import org.suwashizmu.connpassapp.module.view.IEventListView
import org.suwashizmu.connpassapp.view.adapter.EventListAdapter

class EventListFragment : Fragment(), IEventListView {

    companion object {
        fun newInstance(): EventListFragment = EventListFragment()
    }

    private lateinit var binding: EventListFragBinding
    override var presenter: IEventListPresenter? = null
    //ViewModelの変化を監視
    private val disposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.event_list_frag, container, false)

        //setup onClickListenerA

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.listView.adapter = EventListAdapter()
        binding.listView.layoutManager = LinearLayoutManager(activity)

        presenter?.onCreate()
    }

    override fun onResume() {
        super.onResume()

        EventListSubject.observable
                .subscribe(this::update)
                .addTo(disposable)
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

    override fun update(viewModel: EventListViewModel) {
        val adapter = binding.listView.adapter as? EventListAdapter
        adapter?.update(viewModel)
        adapter?.notifyDataSetChanged()
    }

}
