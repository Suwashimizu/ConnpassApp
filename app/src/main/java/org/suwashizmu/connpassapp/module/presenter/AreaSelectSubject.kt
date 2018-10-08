package org.suwashizmu.connpassapp.module.presenter

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.suwashizmu.connpassapp.module.view.AreaSelectViewModel

/**
 * Created by KEKE on 2018/10/07.
 *
 * ViewModelの変更を通知するObserver
 */
object AreaSelectSubject {

    private val subject: PublishSubject<AreaSelectViewModel> = PublishSubject.create()
    val observable: Observable<AreaSelectViewModel> = subject

    fun update(viewModel: AreaSelectViewModel) = subject.onNext(viewModel)
}