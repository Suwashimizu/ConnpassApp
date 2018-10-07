package org.suwashizmu.connpassapp.module.presenter

/**
 * Created by KEKE on 2018/10/07.
 *
 * Fragmentのライフサイクルと同等のメソッドを持つ
 */
interface BasePresenter {

    fun onCreate()

    fun onResume()

    fun onPause()

    fun onDesutroy()
}