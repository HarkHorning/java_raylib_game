package harkhorning.physics.creature

import com.raylib.Raylib.GetFrameTime
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Distance
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract
import harkhorning.physics.objects.CollisionBase

open class Creature(p: Vector2, r: Float, h: Float, w: Float, var damage: Int, var power: Float) : CollisionBase(p, r, h, w)
{

    var canInteractWithPlayer = false
    var distance = 1000f

    init {
        speed.x(100.0f)
        speed.y(50.0f)
        playerL = Vector2().x(GetScreenWidth() / 2f).y(GetScreenHeight() / 2f)
    }

    fun destroy()
    {

    }

    open fun distanceTo(p2: Vector2): Float
    {
        return distance
    }

    open fun update(lockScroll: Vector2, time: Float)
    {
//        p.x(p.x() - lockScroll.x())
//        p.y(p.y() - lockScroll.y())
//
//        direction = Vector2Subtract(playerL, p);
//        direction = Vector2Normalize(direction)
//        direction.x(direction.x() / (speed.x()))
//        direction.y(direction.y() / (speed.y()))
//        p = Vector2Add(p, direction)
//
//        blockPos.x(0.0f).y(0.0f)
    }

    open fun draw()
    {
        drawAreas()
    }
}
