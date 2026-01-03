package harkhorning.core.draws

import harkhorning.core.InitRoot
import harkhorning.core.managers.EntityM

class DrawRoot(var r: InitRoot) {

    val eM: EntityM = r.eM

    fun draw() {
        r.map.drawMap()
        eM.drawEachEntity()
    }
}
