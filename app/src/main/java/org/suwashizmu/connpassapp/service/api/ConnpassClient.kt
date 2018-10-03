package org.suwashizmu.connpassapp.service.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by KEKE on 2018/10/03.
 */
object ConnpassClient {
    private val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://connpass.com/api/v1/")
            .build()

    val service = retrofit.create(ConnpassService::class.java)
}