package harkhorning.physics.creature.player

import com.raylib.Raylib.CheckCollisionRecs
import com.raylib.Raylib.Rectangle
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Length
import com.raylib.Raylib.Vector2Lerp
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract
import com.raylib.Raylib.Vector2Zero
import harkhorning.graphics.animation.AnimationEnums
import harkhorning.physics.creature.Creature
import harkhorning.physics.creature.player.hud.PlayerHealth
import harkhorning.state.StateMachine
import harkhorning.Misc.DeathTimer
import harkhorning.physics.creature.player.attacks.PlayerAttack

class Player(
             p: Vector2,
             r: Float,
             h: Float,
             w: Float,
             damage: Int,
             power: Float,
             val s: StateMachine,
             val playerAttack: PlayerAttack
    ) : Creature(p, r, h, w, damage, power)
{

    val animations = PlayerAnimation()
    val playerHealth = PlayerHealth(4, 4)
    var dead: Boolean = false
    val deathTimer: DeathTimer = DeathTimer(2000)

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
        if (playerHealth.health < 1) {
            animations.setAnimationState(AnimationEnums.DYING)
            stagger = Vector2Zero()
            if (!playerHealth.startedDying) {
                deathTimer.startTimer(s)
                playerHealth.startedDying = true
            }
            return
        }
        if (Vector2Length(stagger) >= 0.5f) {
            animations.setAnimationState(AnimationEnums.STAGGER)
            stagger = Vector2Lerp(stagger, Vector2Zero(), 2.5f * time)
        } else {
            stagger = Vector2Zero()
        }
    }

    override fun draw()
    {
        animations.animate(drawBox())
    }
}
