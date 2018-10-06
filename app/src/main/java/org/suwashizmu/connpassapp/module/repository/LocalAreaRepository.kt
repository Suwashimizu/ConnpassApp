package org.suwashizmu.connpassapp.module.repository

import android.content.Context
import org.suwashizmu.connpassapp.module.entity.Area

/**
 * Created by KEKE on 2018/10/06.
 */
class LocalAreaRepository(private val context: Context) : AreaRepository {

    companion object {
        private const val KEY_AREA = "area"
        private const val KEY_CURRENT_AREA_ID = "currentAreaId"
    }

    override fun getAreaList(): Collection<Area> =
            Area.values().toList()

    override fun save(area: Area) {
        context.getSharedPreferences(KEY_AREA, Context.MODE_PRIVATE)
                .edit()
                .putInt(KEY_CURRENT_AREA_ID, area.id)
                .apply()
    }

    override fun getArea(): Area? =
            if (context.getSharedPreferences(KEY_AREA, Context.MODE_PRIVATE).contains(KEY_CURRENT_AREA_ID)) {
                val id = context.getSharedPreferences(KEY_AREA, Context.MODE_PRIVATE).getInt(KEY_CURRENT_AREA_ID, -1)
                Area.values().first { it.id == id }
            } else {
                null
            }

}