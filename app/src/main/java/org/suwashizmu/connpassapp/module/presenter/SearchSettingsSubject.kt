package org.suwashizmu.connpassapp.module.presenter

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE on 2018/10/21.
 */
object SearchSettingsSubject {

    private val subject: PublishSubject<SearchSettingsViewModel> = PublishSubject.create()
    val observable: Observable<SearchSettingsViewModel> = subject

    fun update(viewModel: SearchSettingsViewModel) = subject.onNext(viewModel)
}