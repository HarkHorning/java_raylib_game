package harkhorning.physics.creature.player

import com.raylib.Raylib
import com.raylib.Raylib.CheckCollisionRecs
import com.raylib.Raylib.Rectangle
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Length
import com.raylib.Raylib.Vector2Lerp
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract
import com.raylib.Raylib.Vector2Zero
import harkhorning.graphics.animation.AnimationEnums
import harkhorning.physics.creature.Creature

class Player(p: Vector2, r: Float, h: Float, w: Float, damage: Int, power: Float) : Creature(p, r, h, w, damage, power)
{

    val animations = PlayerAnimation()

    override fun checkGroundCol(r2: Rectangle, p2: Vector2) : Boolean
    { // come back to this
        val check: Boolean = CheckCollisionRecs(this.groundCollisionRect(), r2)
        if (check)
        {
            val directionVec: Vector2? = Vector2Subtract(p, p2) //
            blockPos = Vector2Normalize(directionVec)
            stagger = Vector2Normalize(directionVec)
        }
        return check
    }

    override fun update(lockScroll: Vector2, time: Float)
    {

        blockPos = Vector2()
        if (Vector2Length(stagger) >= 0.5f) {
            animations.setAnimationState(AnimationEnums.STAGGER)
            stagger = Vector2Lerp(stagger, Vector2Zero(), 2.5f * time)
            println(Vector2Length(stagger))
        } else {
            stagger = Vector2Zero()
        }
    }

    override fun draw()
    {
//        drawAreas()
        animations.animate(drawBox())
    }
}
