package harkhorning.Core.Draws

import com.raylib.Raylib
import harkhorning.Core.InitRoot

class DrawRoot(var initRoot: InitRoot) {

    fun draw() {
        val locked: Raylib.Vector2 = initRoot.GLOBAL_SHIFT
        initRoot.physicsShapes.drawAreas()
        initRoot.player.draw(locked)
    }
}
