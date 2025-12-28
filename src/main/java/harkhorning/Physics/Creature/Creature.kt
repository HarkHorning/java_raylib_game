package harkhorning.Physics.Creature

import com.raylib.Raylib.GetFrameTime
import com.raylib.Raylib.Vector2
import harkhorning.Physics.Object.CollisionBase

open class Creature(p: Vector2, r: Float, h: Float, w: Float) : CollisionBase(p, r, h, w)
{

    var speed: Float = 2.0f * GetFrameTime()

    fun destroy()
    {

    }


    open fun update(lockScroll: Vector2)
    {
        p.x(p.x() - lockScroll.x())
        p.y(p.y() - lockScroll.y())
    }

    open fun draw(lockScroll: Vector2)
    {

    }
}
