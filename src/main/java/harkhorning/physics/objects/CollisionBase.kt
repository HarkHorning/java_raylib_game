package harkhorning.physics.objects

import com.raylib.Raylib.CheckCollisionRecs
import com.raylib.Raylib.Rectangle
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Scale
import com.raylib.Raylib.Vector2Subtract

abstract class CollisionBase(p: Vector2, r: Float, h: Float, w: Float) : PhysicsShapes(p, r, h, w)
{

    var blockPos: Vector2 = Vector2()
    var stagger: Vector2 = Vector2()
    var speed = Vector2()
    var playerL = Vector2()
    var direction = Vector2()
    var health = 2f

    open fun checkGroundCol(r2: Rectangle, p2: Vector2) : Boolean
    {
        val check: Boolean = CheckCollisionRecs(this.groundCollisionRect(), r2)
        if (check)
        {
            val directionVec: Vector2? = Vector2Subtract(p, p2) //
            blockPos = Vector2Normalize(directionVec)
            p = Vector2Add(p, blockPos)
        }
        return check
    }

    fun checkHit(r2: Rectangle, p2: Vector2, direction: Vector2, power: Float, damage: Float) : Boolean
    {
        val check: Boolean = CheckCollisionRecs(this.hitCollisionRect(), r2)
        if (check)
        {
            stagger = Vector2Normalize(direction)
            stagger = Vector2Scale(stagger, power)
            health -= damage
        }
        return check
    }
}
