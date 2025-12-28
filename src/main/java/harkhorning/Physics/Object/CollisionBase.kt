package harkhorning.Physics.Object

import com.raylib.Raylib.CheckCollisionRecs
import com.raylib.Raylib.Rectangle
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract

open class CollisionBase(p: Vector2, r: Float, h: Float, w: Float) : PhysicsShapes(p, r, h, w)
{

    var blockPos: Vector2 = Vector2();
    var stagger: Vector2 = Vector2();

    fun checkGroundCollision(r2: Rectangle, p2: Vector2) : Boolean
    {
        val check: Boolean = CheckCollisionRecs(this.groundCollisionRect(), r2)
        if (check)
        {
            val direction_vec: Vector2? = Vector2Subtract(p, p2) //
            blockPos = Vector2Normalize(direction_vec)
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
