package harkhorning.core.updates

import com.raylib.Raylib
import harkhorning.core.InitRoot
import harkhorning.core.managers.EntityM

class UpdateRoot(val r: InitRoot) {

    val eM: EntityM = r.eM

    fun update() {
        r.playerMovement.check()
        val locked: Raylib.Vector2 = r.globalShift
        r.map.updateMap(locked)
        eM.forEachEntity(locked)
    }
}
