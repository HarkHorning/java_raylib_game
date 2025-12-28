package harkhorning.Core.Updates

import com.raylib.Raylib
import harkhorning.Core.InitRoot
import harkhorning.Core.Managers.EntityM

class UpdateRoot(val r: InitRoot) {

    val eM: EntityM = r.eM

    fun update() {
        r.playerMovement.check()
        val locked: Raylib.Vector2 = r.GLOBAL_SHIFT
        r.map.updateMap(locked)
        eM.forEachEntity(locked)
    }
}
