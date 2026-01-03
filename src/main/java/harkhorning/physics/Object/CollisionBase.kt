package harkhorning.physics.Object

import com.raylib.Raylib.CheckCollisionRecs
import com.raylib.Raylib.Rectangle
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract

open class CollisionBase(p: Vector2, r: Float, h: Float, w: Float) : PhysicsShapes(p, r, h, w)
{

    var blockPos: Vector2 = Vector2();
    var stagger: Vector2 = Vector2();
    var speed = Vector2()
    var playerL = Vector2()
    var direction = Vector2()
    var drawPlacement: Int = 0;

    open fun updateDrawOrder() {
        drawPlacement = p.y().toInt()
    }

    open fun checkGroundCol(r2: Rectangle, p2: Vector2) : Boolean
    {
        val check: Boolean = CheckCollisionRecs(this.groundCollisionRect(), r2)
        if (check)
        {
            val direction_vec: Vector2? = Vector2Subtract(p, p2) //
            blockPos = Vector2Normalize(direction_vec)
            p = Vector2Add(p, blockPos)
        }
        return check
    }

    fun checkHit(r2: Rectangle, p2: Vector2) : Boolean
    {
        val check: Boolean = CheckCollisionRecs(this.hitCollisionRect(), r2)
        if (check)
        {
            val direction_vec: Vector2? = Vector2Subtract(p, p2) //
            stagger = Vector2Normalize(direction_vec)
        }
        return check
    }
}
