package harkhorning.Core.Draws

import com.raylib.Raylib
import harkhorning.Core.InitRoot

class DrawRoot(var initRoot: InitRoot) {

    fun draw(p: Raylib.Vector2) {
        println(initRoot.handshake)
    }
}
