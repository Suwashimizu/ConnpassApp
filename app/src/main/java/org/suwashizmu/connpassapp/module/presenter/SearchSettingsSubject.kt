package org.suwashizmu.connpassapp.module.presenter

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE on 2018/10/21.
 */
object SearchSettingsSubject {

    private val subject: BehaviorSubject<SearchSettingsViewModel> = BehaviorSubject.create()
    val observable: Observable<SearchSettingsViewModel> = subject

    fun update(viewModel: SearchSettingsViewModel) = subject.onNext(viewModel)
}