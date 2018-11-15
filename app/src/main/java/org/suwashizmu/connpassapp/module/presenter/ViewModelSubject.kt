package org.suwashizmu.connpassapp.module.presenter

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by KEKE on 2018/10/21.
 */
abstract class ViewModelSubject<T> {

    protected val subject: BehaviorSubject<T> = BehaviorSubject.create()
    val observable: Observable<T> = subject

    abstract fun update(t: T)
}