package org.suwashizmu.connpassapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import org.suwashizmu.connpassapp.module.view.EventListViewModel

/**
 * Created by KEKE on 2018/10/15.
 */
class EventListAdapter : RecyclerView.Adapter<EventListAdapter.EventOverviewViewHolder>() {

    private val eventList = mutableSetOf<EventListViewModel.Event>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): EventOverviewViewHolder =
            EventOverviewViewHolder(LayoutInflater.from(p0.context).inflate(android.R.layout.simple_list_item_1, p0, false) as TextView)

    override fun onBindViewHolder(p0: EventOverviewViewHolder, p1: Int) {
        p0.view.text = eventList.elementAt(p1).title
    }

    override fun getItemCount(): Int = eventList.size

    fun update(viewModel: EventListViewModel) {
        //TODO diffTool使いたい
        eventList.addAll(viewModel.eventList)
    }

    class EventOverviewViewHolder(val view: TextView) : RecyclerView.ViewHolder(view) {

    }
}