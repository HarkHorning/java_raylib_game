package harkhorning.physics.creature.enemies

import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Distance
import com.raylib.Raylib.Vector2Length
import com.raylib.Raylib.Vector2Lerp
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract
import com.raylib.Raylib.Vector2Zero
import harkhorning.graphics.animation.AnimationDirection
import harkhorning.graphics.animation.AnimationEnums
import harkhorning.physics.creature.Creature

class BasicEnemy(p: Vector2, r: Float, h: Float, w: Float, damage: Int, power: Float) : Creature(p, r, h, w, damage, power) {

    val animator = BasicEnemyAnimator("src/main/resources/assets/enemy_skeleton_32.png")
    var dying = false

    override fun distanceTo(p2: Vector2): Float
    {
        return Vector2Distance(p, p2)
    }

    fun checkAnimState(d: Vector2)
    {
        if (d.x() != 0f || d.y() != 0f && animator.currentAnimation != animator.moving) {
            animator.setAnimationState(AnimationEnums.WALKING)
            if (d.x() < 0) {
                animator.direction = AnimationDirection.LEFT
            } else { animator.direction = AnimationDirection.RIGHT }
        } else { animator.setAnimationState(AnimationEnums.STANDING) }
    }

    fun moveToPlayer(time: Float)
    {
        direction = Vector2Subtract(playerL, p);
        direction = Vector2Normalize(direction)
        direction.x(direction.x() * (speed.x() * time))
        direction.y(direction.y() * (speed.y() * time))
        checkAnimState(direction)
        p = Vector2Add(p, direction)
    }

    override fun update(lockScroll: Vector2, time: Float)
    {
        p.x(p.x() - lockScroll.x() + stagger.x())
        p.y(p.y() - lockScroll.y() + stagger.y())

        if (!canInteractWithPlayer) {
            moveToPlayer(time)
        } else {
            // more attack logic here
        }

        if (Vector2Length(stagger) >= 0.5f) {
            animator.setAnimationState(AnimationEnums.STAGGER)
            stagger = Vector2Lerp(stagger, Vector2Zero(), 2.5f * time)
        } else {
            stagger = Vector2Zero()
        }

        blockPos.x(0.0f).y(0.0f)
        canInteractWithPlayer = false
        if (health < 1) {
            animator.setAnimationState(AnimationEnums.DYING)
            if (!dying) {
                creatureDeathTimer.startTimer(this)
                dying = true
            }
        }
    }

    override fun draw()
    {
        animator.animate(drawBox())
    }
}