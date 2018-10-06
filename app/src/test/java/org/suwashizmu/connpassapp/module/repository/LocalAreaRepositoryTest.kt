package org.suwashizmu.connpassapp.module.repository

import android.content.Context
import android.content.SharedPreferences
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area

/**
 * Created by KEKE on 2018/10/06.
 */
class LocalAreaRepositoryTest {

    //preferenceのmockを生成する,roborectoriでも良いかも
    private val editor: SharedPreferences.Editor = mock {
        on { putInt(any(), any()) } doReturn it
    }

    private val pref: SharedPreferences = mock {
        on { edit() } doReturn editor
    }

    private val context: Context = mock {
        on { getSharedPreferences("area", Context.MODE_PRIVATE) } doReturn pref
    }

    private val repository = LocalAreaRepository(context)

    @Test
    fun getAreaList() {
        assertThat(repository.getAreaList().size).isEqualTo(47)
    }

    @Test
    fun save() {
        repository.save(Area.FUKUOKA)

        val key = "area"
        val mode = Context.MODE_PRIVATE

        verify(context.getSharedPreferences(key, mode)).edit()
        verify(context.getSharedPreferences(key, mode).edit().putInt(any(), any())).apply()
        verify(context.getSharedPreferences(key, mode).edit().putInt(any(), any())).apply()
    }
}