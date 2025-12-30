package harkhorning.Core.Draws

import com.raylib.Raylib
import harkhorning.Core.InitRoot
import harkhorning.Core.Managers.EntityM

class DrawRoot(var r: InitRoot) {

    val eM: EntityM = r.eM

    fun draw() {
        r.map.drawMap()
        eM.drawEachEntity()
    }
}
