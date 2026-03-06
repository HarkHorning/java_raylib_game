package harkhorning.core.updates

import com.raylib.Raylib
import com.raylib.Raylib.GetFrameTime
import harkhorning.core.InitRoot
import harkhorning.core.managers.EntityM

class UpdateRoot(val r: InitRoot) {

    val eM: EntityM = r.eM

    fun update() {
        val time: Float = GetFrameTime()
        r.playerMovement.check(time)
        val locked: Raylib.Vector2 = r.globalShift
        r.map.updateMap(locked)
        eM.forEachEntity(locked, time)
    }
}
