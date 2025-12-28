package harkhorning.Core.Updates

import com.raylib.Raylib
import com.raylib.Raylib.IsKeyDown
import com.raylib.Raylib.KEY_D
import harkhorning.Core.InitRoot

class UpdateRoot(var initRoot: InitRoot) {

    fun update() {
        if (IsKeyDown(KEY_D)) {
            initRoot.GLOBAL_SHIFT.x(initRoot.GLOBAL_SHIFT.x() + 1)
            println("D PRESSED")
        }
        val locked: Raylib.Vector2 = initRoot.GLOBAL_SHIFT
        initRoot.physicsShapes.update(locked)
        initRoot.player.update(locked)
    }
}
