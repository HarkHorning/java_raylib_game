package harkhorning.physics.creature.player

import com.raylib.Raylib.CheckCollisionRecs
import com.raylib.Raylib.Rectangle
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract
import harkhorning.physics.creature.Creature

class Player(p: Vector2, r: Float, h: Float, w: Float) : Creature(p, r, h, w)
{

    val animations = PlayerAnimation()

    override fun checkGroundCol(r2: Rectangle, p2: Vector2) : Boolean
    { // come back to this
        val check: Boolean = CheckCollisionRecs(this.groundCollisionRect(), r2)
        if (check)
        {
            val direction_vec: Vector2? = Vector2Subtract(p, p2) //
            blockPos = Vector2Normalize(direction_vec)
//            p = Vector2Add(p, blockPos)
        }
        return check
    }

    override fun update(lockScroll: Vector2)
    {

    }

    override fun draw()
    {
        drawAreas()
        animations.animate(drawBox())
    }
}
