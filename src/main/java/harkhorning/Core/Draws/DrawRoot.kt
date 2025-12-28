package harkhorning.Core.Draws

import com.raylib.Raylib
import harkhorning.Core.InitRoot

class DrawRoot(var root: InitRoot) {

    fun draw() {
        val locked: Raylib.Vector2 = root.GLOBAL_SHIFT
        root.physicsShapes.drawAreas()
        root.player.draw(locked)
    }
}
