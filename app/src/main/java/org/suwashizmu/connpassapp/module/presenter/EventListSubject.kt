package org.suwashizmu.connpassapp.module.presenter

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.suwashizmu.connpassapp.module.view.EventListViewModel

/**
 * Created by KEKE on 2018/10/15.
 */
object EventListSubject {

    private val subject: PublishSubject<EventListViewModel> = PublishSubject.create()
    val observable: Observable<EventListViewModel> = subject

    fun update(viewModel: EventListViewModel) = subject.onNext(viewModel)
}