package harkhorning.physics.creature.player.hud

import com.raylib.Colors
import com.raylib.Raylib
import harkhorning.core.HardGlobalVariables
import harkhorning.core.InitRoot
import harkhorning.physics.creature.player.Player

class PlayerHud(val root: InitRoot, val player: Player) {
    val hC: HardGlobalVariables = HardGlobalVariables()
    val span: Int = (16 * hC.scaler / 1.75).toInt()
    val playerHealth: PlayerHealth = PlayerHealth(root, player, 5, 4, span)
    val playerLevel: PlayerLevel = PlayerLevel(root, player, span)
    val bgRect: Raylib.Rectangle = Raylib.Rectangle().x(0f).y(0f).width(0f).height(0f)

    init {
        bgRect.width(Raylib.GetScreenWidth().toFloat()).height(span.toFloat() * 1.5f)
    }

    fun drawHud() {
        Raylib.DrawRectangleRec(bgRect, Raylib.Fade(Colors.BLACK, 0.3f))
        playerHealth.drawHealth()
        playerLevel.drawLevel()
        Raylib.DrawFPS(20, (span * 2.25).toInt())
    }
}