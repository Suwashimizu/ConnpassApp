package org.suwashizmu.connpassapp.view


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.WizardInterestCategoriesFragBinding
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.presenter.IInterestCategoriesPresenter
import org.suwashizmu.connpassapp.module.presenter.InterestCategoriesSubject
import org.suwashizmu.connpassapp.module.view.IInterestCategoriesView
import org.suwashizmu.connpassapp.module.view.InterestCategoriesViewModel

/**
 * Created by KEKE on 2018/10/08.
 */
class WizardInterestFragment : Fragment(), IInterestCategoriesView {

    companion object {
        fun newInstance(): WizardInterestFragment =
                WizardInterestFragment()
    }

    private val subject = InterestCategoriesSubject
    private val disposable = CompositeDisposable()

    private lateinit var binding: WizardInterestCategoriesFragBinding

    override var presenter: IInterestCategoriesPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.wizard_interest_categories_frag, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        //ViewModelの更新の購読
        subject.observable
                .subscribe(this::update)
                .addTo(disposable)

        presenter?.fetchInterestCategories()
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

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.wizard_area, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_next) {

            val checked = binding.listView.checkedItemPositions

            val selectedItems = mutableListOf<InterestCategory>()
            for (i in 0 until checked.size()) {
                if (checked[i]) {
                    selectedItems.add(binding.listView.getItemAtPosition(checked.keyAt(i)) as InterestCategory)
                }
            }

            presenter?.onClickNextButton(*selectedItems.toTypedArray())
            return true
        }
        return super.onContextItemSelected(item)
    }

    //region IInterestCategoriesView
    override fun update(viewModel: InterestCategoriesViewModel) {

        //listView adapter
        Logger.d(viewModel)

        if (binding.listView.adapter == null) {
            binding.listView.adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_multiple_choice, viewModel.interestCategories.toMutableList())
            binding.listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        }

        if (viewModel.inputState == InterestCategoriesViewModel.InputState.ERROR) {
            Toast.makeText(activity, "Errorです", Toast.LENGTH_SHORT).show()
        }
    }
    //endregion IInterestCategoriesView
}