package harkhorning.physics.creature

import com.raylib.Raylib.GetFrameTime
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Distance
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract
import harkhorning.Misc.CreatureDeathTimer
import harkhorning.physics.objects.CollisionBase

open class Creature(p: Vector2, r: Float, h: Float, w: Float, var damage: Int, var power: Float) : CollisionBase(p, r, h, w)
{

    var canInteractWithPlayer = false
    var distance = 1000f
    val creatureDeathTimer: CreatureDeathTimer = CreatureDeathTimer(1500)
    var dead = false

    init {
        speed.x(100.0f)
        speed.y(50.0f)
        playerL = Vector2().x(GetScreenWidth() / 2f).y(GetScreenHeight() / 2f)
    }

    fun destroy()
    {
        dead = true
    }

    open fun distanceTo(p2: Vector2): Float
    {
        return distance
    }

    open fun update(lockScroll: Vector2, time: Float)
    {

    }

    open fun draw()
    {
        drawAreas()
    }
}
