package harkhorning.Core.Updates

import com.raylib.Raylib
import harkhorning.Core.InitRoot

class UpdateRoot(var initRoot: InitRoot) {

    fun update(p: Raylib.Vector2) {
        println(initRoot.handshake)
    }
}
