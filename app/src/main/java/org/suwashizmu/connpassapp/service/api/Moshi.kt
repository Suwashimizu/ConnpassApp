package org.suwashizmu.connpassapp.service.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

/**
 * Created by KEKE on 2018/10/02.
 */

val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()