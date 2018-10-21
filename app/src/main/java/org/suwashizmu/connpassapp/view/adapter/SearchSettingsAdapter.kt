package org.suwashizmu.connpassapp.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE on 2018/10/21.
 */
class SearchSettingsAdapter : RecyclerView.Adapter<SearchSettingsViewHolder>() {

    companion object {
        private const val ITEM_SIZE = 2

        private const val VIEW_TYPE_AREA = 0
        private const val VIEW_TYPE_INTEREST = 1
    }

    var viewModel: SearchSettingsViewModel? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSettingsViewHolder =

            when (viewType) {
                VIEW_TYPE_AREA -> SearchSettingsViewHolder.ItemArea(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.search_settings_item, parent, false)).apply {
                    itemView.setOnClickListener {

                    }
                }
                VIEW_TYPE_INTEREST -> SearchSettingsViewHolder.ItemInterest(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.search_settings_item, parent, false)).apply {
                    itemView.setOnClickListener {

                    }
                }
                else -> throw IllegalStateException("index out of bounds")
            }

    override fun onBindViewHolder(viewHolder: SearchSettingsViewHolder, position: Int) {
        when (viewHolder) {
            is SearchSettingsViewHolder.ItemArea -> {
                viewHolder.binding.label.text = viewHolder.binding.root.resources.getString(R.string.area)
                viewHolder.binding.value.text = viewModel?.area?.name
            }
            is SearchSettingsViewHolder.ItemInterest -> {
                viewHolder.binding.label.text = viewHolder.binding.root.resources.getString(R.string.interest)
                //興味あるものは,で連結させる
                viewHolder.binding.value.text = viewModel?.interestCategories?.joinToString(separator = ",")
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
            when (position) {
                0 -> VIEW_TYPE_AREA
                1 -> VIEW_TYPE_INTEREST
                else -> throw IllegalStateException("index out of bounds")
            }

    override fun getItemCount(): Int = ITEM_SIZE
}