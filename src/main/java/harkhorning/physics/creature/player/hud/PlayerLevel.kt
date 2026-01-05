package harkhorning.physics.creature.player.hud

import com.raylib.Colors.LIGHTGRAY
import com.raylib.Colors.YELLOW
import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.core.InitRoot
import harkhorning.physics.creature.player.Player

class PlayerLevel(val root: InitRoot, val player: Player, var span: Int) {

    var nextLevel: Int = 25
    var progress: Int = 5

    fun getLevelBar(): Raylib.Rectangle
    {
        val percent = progress / nextLevel.toDouble()
        return Raylib.Rectangle().x(0f).y((span * 1.5f) + 1).width((percent * GetScreenWidth()).toFloat()).height(3f)
    }

    fun drawLevel()
    {
        Raylib.DrawRectangleLines(0, (span * 1.5f).toInt(), GetScreenWidth()+1, 5, LIGHTGRAY)
        Raylib.DrawRectangleRec(getLevelBar(), YELLOW)
    }
}