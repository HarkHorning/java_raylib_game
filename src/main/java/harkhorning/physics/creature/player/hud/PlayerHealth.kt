package harkhorning.physics.creature.player.hud

import com.raylib.Colors
import com.raylib.Raylib
import harkhorning.core.HardGlobalVariables
import harkhorning.core.InitRoot
import harkhorning.physics.creature.player.Player

class PlayerHealth(var maxHealth: Int, var health: Int) {

    val hC: HardGlobalVariables = HardGlobalVariables()
    val span: Int = (16 * hC.scaler / 1.75).toInt()
    val sprite: Raylib.Texture? = Raylib.LoadTexture("src/main/resources/assets/heart_16.png")
    var placementOrigin: Int = 0
    var startedDying: Boolean = false

    init {
        placementOrigin = (Raylib.GetScreenWidth() / 2) - ((maxHealth * span) / 1.3).toInt()
    }

    fun drawHealth()
    {
        val dest: Raylib.Rectangle = Raylib.Rectangle()
            .x(placementOrigin.toFloat())
            .y(span.toFloat() / 4)
            .width(span.toFloat())
            .height(span.toFloat())

        for (i in 0 until maxHealth) {

            dest.x(dest.x() + span.toFloat())

            val spriteRect = Raylib.Rectangle()
                .x(0f)
                .y(0f)
                .width(16f)
                .height(16f)

            if (i > health - 1) {
                spriteRect.x(16f)
            }

            Raylib.DrawTexturePro(
                sprite, spriteRect, dest,
                Raylib.Vector2(), 0f, Colors.WHITE
            )
        }
    }
}