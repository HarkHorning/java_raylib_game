package harkhorning.Core.Draws

import com.raylib.Raylib
import harkhorning.Core.InitRoot
import harkhorning.Core.Managers.EntityM

class DrawRoot(var r: InitRoot) {

    val eM: EntityM = r.eM

    fun draw() {
        val locked: Raylib.Vector2 = r.GLOBAL_SHIFT
        r.map.drawMap(locked)
        eM.drawEachEntity(locked)
    }
}
