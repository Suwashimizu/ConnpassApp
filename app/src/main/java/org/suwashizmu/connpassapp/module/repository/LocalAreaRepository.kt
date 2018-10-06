package org.suwashizmu.connpassapp.module.repository

import android.content.Context
import org.suwashizmu.connpassapp.module.entity.Area

/**
 * Created by KEKE on 2018/10/06.
 */
class LocalAreaRepository(private val context: Context) : AreaRepository {

    override fun getAreaList(): Collection<Area> =
            Area.values().toList()

    override fun save(area: Area) {
        context.getSharedPreferences("area", Context.MODE_PRIVATE)
                .edit()
                .putInt("currentAreaId", area.id)
                .apply()
    }
}