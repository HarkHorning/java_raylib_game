package harkhorning.Core.Updates

import com.raylib.Raylib
import com.raylib.Raylib.IsKeyDown
import com.raylib.Raylib.KEY_D
import harkhorning.Core.InitRoot

class UpdateRoot(var root: InitRoot) {

    fun update() {
        root.playerMovement.check()
        val locked: Raylib.Vector2 = root.GLOBAL_SHIFT
        root.physicsShapes.update(locked)
        root.player.update(locked)
    }
}
