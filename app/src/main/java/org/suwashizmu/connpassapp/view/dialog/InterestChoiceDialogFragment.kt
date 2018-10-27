package org.suwashizmu.connpassapp.view.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel
import org.suwashizmu.connpassapp.view.SearchSettingsFragment

/**
 * Created by KEKE on 2018/10/21.
 */
class InterestChoiceDialogFragment : DialogFragment() {

    companion object {

        private const val KEY_INTEREST_SOURCE = "interest"

        fun newInstance(target: SearchSettingsFragment, requestCode: Int, viewModel: SearchSettingsViewModel): InterestChoiceDialogFragment {
            return InterestChoiceDialogFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_INTEREST_SOURCE, viewModel.interestCategoriesSource?.toTypedArray())
                }
                setTargetFragment(target, requestCode)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val searchSettingsFragment = targetFragment as SearchSettingsFragment
        val interestSource: Array<InterestCategory> = arguments!!.getSerializable(KEY_INTEREST_SOURCE) as Array<InterestCategory>

        val choicesItems = mutableSetOf<Int>()

        return AlertDialog.Builder(requireActivity())
                .setMultiChoiceItems(interestSource.map { it.name }.toTypedArray(), null) { _, which, isChecked ->
                    if (isChecked) {
                        choicesItems.add(which)
                    } else {
                        choicesItems.remove(which)
                    }
                }
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    searchSettingsFragment.presenter?.onInterestSelected(
                            interestSource.filterIndexed { index, _ -> choicesItems.contains(index) }
                    )
                }
                .setNegativeButton(android.R.string.cancel, null)
                .create()
    }
}