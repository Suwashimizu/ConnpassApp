package org.suwashizmu.connpassapp.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.EventListFragBinding
import org.suwashizmu.connpassapp.module.presenter.EventListSubject
import org.suwashizmu.connpassapp.module.presenter.IEventListPresenter
import org.suwashizmu.connpassapp.module.view.EventListViewModel
import org.suwashizmu.connpassapp.module.view.IEventListView
import org.suwashizmu.connpassapp.view.adapter.EventListAdapter

class EventListFragment : androidx.fragment.app.Fragment(), IEventListView {

    companion object {
        fun newInstance(): EventListFragment = EventListFragment()
    }

    private lateinit var binding: EventListFragBinding
    override var presenter: IEventListPresenter? = null
    //ViewModelの変化を監視
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.event_list_frag, container, false)

        //setup onClickListener
        binding.swipeRefresh.setOnRefreshListener(refreshListener)

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (requireActivity() as AppCompatActivity).supportActionBar?.setTitle(R.string.app_name)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.listView.adapter = EventListAdapter {
            Logger.d("ItemClicked:$it")
            presenter?.onItemClick(it)
        }
        binding.listView.addOnScrollListener(loadMoreListener)
        binding.listView.layoutManager = LinearLayoutManager(activity)

        presenter?.onCreate()
    }

    override fun onResume() {
        super.onResume()

        presenter?.onResume()

        EventListSubject.observable
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

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.event_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_search) presenter?.onSearchIconClicked()
        return super.onOptionsItemSelected(item)
    }

    override fun update(viewModel: EventListViewModel) {
        val adapter = binding.listView.adapter as? EventListAdapter
        adapter?.update(viewModel)

        //次のEventが無ければload中にする
        loadMoreListener.isLoading = viewModel.hasNextEvents.not()
        adapter?.isLoading = false

        binding.swipeRefresh.isRefreshing = viewModel.refreshing
        binding.progress.visibility = if (viewModel.loading) View.VISIBLE else View.GONE

        //Errorの表示
        if (viewModel.error != null) {
            Toast.makeText(activity, viewModel.error!!.message, Toast.LENGTH_SHORT).show()
            adapter?.isLoading = false
        }

        adapter?.notifyDataSetChanged()
    }

    private val refreshListener: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener {
        presenter?.onPullRefresh()
    }

    private val loadMoreListener = LoadMoreListener {
        Logger.d("loadMore!!!!!!")
        val adapter = binding.listView.adapter as? EventListAdapter
        //呼ばれた時は常にLoad中
        adapter?.isLoading = true
        adapter?.notifyDataSetChanged()
        presenter?.onScrollEnd()
    }

}
