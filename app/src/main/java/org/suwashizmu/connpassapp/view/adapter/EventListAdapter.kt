package org.suwashizmu.connpassapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.orhanobut.logger.Logger
import org.suwashizmu.connpassapp.databinding.EventListItemBinding
import org.suwashizmu.connpassapp.databinding.ProgressItemBinding
import org.suwashizmu.connpassapp.module.view.EventListViewModel

/**
 * Created by KEKE on 2018/10/15.
 */
class EventListAdapter(private val itemClickCallback: (event: EventListViewModel.Event) -> Unit) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_PROGRESS = 1
    }

    private val eventList = mutableSetOf<EventListViewModel.Event>()

    var isLoading = false

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder =
            when (viewType) {
                VIEW_TYPE_ITEM -> {
                    EventOverviewViewHolder(EventListItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)).apply {
                        itemView.setOnClickListener {
                            itemClickCallback(eventList.elementAt(adapterPosition))
                        }
                    }
                }
                VIEW_TYPE_PROGRESS -> {
                    ProgressViewHolder(ProgressItemBinding.inflate(LayoutInflater.from(p0.context), p0, false))
                }
                else -> throw IllegalStateException("undefined ViewType")
            }

    override fun onBindViewHolder(viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        when (viewHolder) {
            is EventOverviewViewHolder -> viewHolder.onBind(eventList.elementAt(position))
        }
    }

    //Loading中かつ最後のアイテムはProgress
    override fun getItemViewType(position: Int): Int {
        return if (isLoading) {
            if (position == itemCount - 1) VIEW_TYPE_PROGRESS else VIEW_TYPE_ITEM
        } else {
            VIEW_TYPE_ITEM
        }
    }

    override fun getItemCount(): Int = if (isLoading) eventList.size + 1 else eventList.size

    fun update(viewModel: EventListViewModel) {
        //TODO diffTool使いたい
        eventList.clear()
        eventList.addAll(viewModel.eventList)
        
        Logger.d("EventListSize:${eventList.size}")
    }

    class EventOverviewViewHolder(private val binding: EventListItemBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun onBind(event: EventListViewModel.Event) {
            binding.text1.text = event.title
            binding.text2.text = event.catch
        }
    }

    class ProgressViewHolder(private val binding: ProgressItemBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)
}