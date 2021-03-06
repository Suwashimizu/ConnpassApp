package org.suwashizmu.connpassapp.view.adapter

import android.view.View
import org.suwashizmu.connpassapp.databinding.SearchSettingsItemBinding

/**
 * Created by KEKE on 2018/10/21.
 */
sealed class SearchSettingsViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

    class ItemArea(val binding: SearchSettingsItemBinding) : SearchSettingsViewHolder(binding.root)
    class ItemInterest(val binding: SearchSettingsItemBinding) : SearchSettingsViewHolder(binding.root)
}