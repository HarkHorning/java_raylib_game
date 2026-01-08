package harkhorning.physics.projectile

import com.raylib.Colors.PINK
import com.raylib.Raylib
import com.raylib.Raylib.GetFrameTime
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract
import harkhorning.physics.creature.player.attacks.AttackType

class BasicAttack(
    var targetP: Raylib.Vector2
) {
    var p: Raylib.Vector2 = Raylib.Vector2()
    var direction: Raylib.Vector2 = Raylib.Vector2()
    val speed: Raylib.Vector2 = Raylib.Vector2().x(500f).y(480f)
    val radius: Raylib.Vector2 = Raylib.Vector2().x(10f).y(10f)
    val damage: Float = 1f
    val power: Float = 12f

    init {
        p.x((GetScreenWidth() / 2).toFloat()).y((GetScreenHeight() / 2).toFloat())
        direction = Vector2Subtract(targetP, p)
        direction = Vector2Normalize(direction)
        direction.x(direction.x() * (speed.x() * GetFrameTime()))
        direction.y(direction.y() * (speed.y() * GetFrameTime()))
    }

    fun getCollisionRect() : Raylib.Rectangle
    {
        return Raylib.Rectangle().x(p.x() - radius.x()).y(p.y() - radius.y()).width(radius.x() * 2).height(radius.y() * 2)
    }

    fun update(lockScroll: Raylib.Vector2)
    {
        p.x(p.x() - lockScroll.x())
        p.y(p.y() - lockScroll.y())
        p = Vector2Add(p, direction)
    }

    fun draw()
    {
        Raylib.DrawRectangleRec(getCollisionRect(), PINK)
    }
}