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

        private const val KEY_INTEREST_SOURCE = "source"
        private const val KEY_CURRENT = "currentValues"

        fun newInstance(target: SearchSettingsFragment, requestCode: Int, viewModel: SearchSettingsViewModel): InterestChoiceDialogFragment {
            return InterestChoiceDialogFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_INTEREST_SOURCE, viewModel.interestCategoriesSource?.toTypedArray())
                    putSerializable(KEY_CURRENT, viewModel.interestCategories.toTypedArray())
                }
                setTargetFragment(target, requestCode)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val searchSettingsFragment = targetFragment as SearchSettingsFragment
        val interestSource: Array<InterestCategory> = arguments!!.getSerializable(KEY_INTEREST_SOURCE) as Array<InterestCategory>
        val currentSelectedItems = arguments!!.getSerializable(KEY_CURRENT) as Array<InterestCategory>
        val checkedItems = interestSource.map { currentSelectedItems.contains(it) }

        return AlertDialog.Builder(requireActivity())
                .setMultiChoiceItems(interestSource.map { it.name }.toTypedArray(), checkedItems.toBooleanArray(), null)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    val checkedItemPositions = (dialog as AlertDialog).listView.checkedItemPositions
                    //trueのkeyのみ取得する
                    val checkedKeys = IntRange(0, checkedItemPositions.size() - 1)
                            //keyの取得
                            .map {
                                checkedItemPositions.keyAt(it)
                            }
                            .filter {
                                checkedItemPositions.get(it)
                            }.toList()
                    searchSettingsFragment.presenter?.onInterestSelected(
                            checkedKeys.map { interestSource[it] }
                    )

                }
                .setNegativeButton(android.R.string.cancel, null)
                .create()
    }
}