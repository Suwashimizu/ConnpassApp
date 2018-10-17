package org.suwashizmu.connpassapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.suwashizmu.connpassapp.databinding.EventListItemBinding
import org.suwashizmu.connpassapp.module.view.EventListViewModel

/**
 * Created by KEKE on 2018/10/15.
 */
class EventListAdapter(private val itemClickCallback: (event: EventListViewModel.Event) -> Unit) : RecyclerView.Adapter<EventListAdapter.EventOverviewViewHolder>() {

    private val eventList = mutableSetOf<EventListViewModel.Event>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): EventOverviewViewHolder =
            EventOverviewViewHolder(EventListItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)).apply {
                itemView.setOnClickListener {
                    itemClickCallback(eventList.elementAt(adapterPosition))
                }
            }

    override fun onBindViewHolder(p0: EventOverviewViewHolder, p1: Int) {
        p0.onBind(eventList.elementAt(p1))
    }

    override fun getItemCount(): Int = eventList.size

    fun update(viewModel: EventListViewModel) {
        //TODO diffTool使いたい
        eventList.clear()
        eventList.addAll(viewModel.eventList)
    }

    class EventOverviewViewHolder(private val binding: EventListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(event: EventListViewModel.Event) {
            binding.text1.text = event.title
            binding.text2.text = event.catch
        }
    }
}