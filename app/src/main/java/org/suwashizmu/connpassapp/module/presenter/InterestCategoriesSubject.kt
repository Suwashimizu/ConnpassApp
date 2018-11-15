package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.view.InterestCategoriesViewModel

/**
 * Created by KEKE on 2018/10/08.
 */
object InterestCategoriesSubject : ViewModelSubject<InterestCategoriesViewModel>() {
    override fun update(t: InterestCategoriesViewModel) = subject.onNext(t)
}