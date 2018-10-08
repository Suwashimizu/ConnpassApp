package org.suwashizmu.connpassapp.module.presenter

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.suwashizmu.connpassapp.module.view.InterestCategoriesViewModel

/**
 * Created by KEKE on 2018/10/08.
 */
object InterestCategoriesSubject {

    private val subject: PublishSubject<InterestCategoriesViewModel> = PublishSubject.create()
    val observable: Observable<InterestCategoriesViewModel> = subject

    fun update(viewModel: InterestCategoriesViewModel) = subject.onNext(viewModel)
}