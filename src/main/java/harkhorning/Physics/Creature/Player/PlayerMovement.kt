package harkhorning.Physics.Creature.Player

import com.raylib.Raylib.Vector2
import com.raylib.Raylib.IsKeyDown
import com.raylib.Raylib.KEY_A
import com.raylib.Raylib.KEY_D
import com.raylib.Raylib.KEY_S
import com.raylib.Raylib.KEY_W
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Normalize
import harkhorning.Core.InitRoot

class PlayerMovement(val root: InitRoot, val player: Player) {

    var inputM: Vector2 = Vector2()
    var playerSpeed: Vector2 = Vector2().x(4.0f).y(2.0f)

    fun normalize()
    {
        inputM = Vector2Normalize(inputM)
        root.GLOBAL_SHIFT.x(inputM.x() * playerSpeed.x())
        root.GLOBAL_SHIFT.y(inputM.y() * playerSpeed.y())
        root.GLOBAL_SHIFT = Vector2Add(root.GLOBAL_SHIFT, player.stagger)
    }

    fun check()
    {
        if (IsKeyDown(KEY_D) && player.blockPos.x() >= 0.0f) { inputM.x(1.0f) }
        else if (IsKeyDown(KEY_A) && player.blockPos.x() <= 0.0f) { inputM.x(-1.0f) }
        else {
            root.GLOBAL_SHIFT.x(0.0f)
            inputM.x(0.0f)
        }

        if (IsKeyDown(KEY_S) && player.blockPos.y() >= 0.0f) { inputM.y(1.0f) }
        else if (IsKeyDown(KEY_W) && player.blockPos.y() <= 0.0f) { inputM.y(-1.0f) }
        else {
            root.GLOBAL_SHIFT.y(0.0f)
            inputM.y(0.0f)
        }
        normalize()
    }
}
