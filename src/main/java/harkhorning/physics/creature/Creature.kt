package harkhorning.physics.creature

import com.raylib.Raylib.GetFrameTime
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Scale
import com.raylib.Raylib.Vector2Subtract
import harkhorning.physics.Object.CollisionBase

open class Creature(p: Vector2, r: Float, h: Float, w: Float) : CollisionBase(p, r, h, w)
{

    init {
        speed.x(1.0f)
        speed.y(2.0f)
        playerL = Vector2().x(GetScreenWidth() / 2f).y(GetScreenHeight() / 2f)
    }

    fun destroy()
    {

    }

    open fun update(lockScroll: Vector2)
    {
        p.x(p.x() - lockScroll.x())
        p.y(p.y() - lockScroll.y())

        direction = Vector2Subtract(playerL, p);
        direction = Vector2Normalize(direction)
        direction.x(direction.x() / (speed.x()))
        direction.y(direction.y() / (speed.y()))
        p = Vector2Add(p, direction)

        blockPos.x(0.0f).y(0.0f)
    }

    open fun draw()
    {
        drawAreas()
    }
}
