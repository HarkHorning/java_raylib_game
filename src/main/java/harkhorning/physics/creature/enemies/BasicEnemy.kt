package harkhorning.physics.creature.enemies

import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Normalize
import com.raylib.Raylib.Vector2Subtract
import harkhorning.graphics.animation.AnimationDirection
import harkhorning.graphics.animation.AnimationEnums
import harkhorning.physics.creature.Creature

class BasicEnemy(p: Vector2, r: Float, h: Float, w: Float) : Creature(p, r, h, w) {

    val animator = BasicEnemyAnimator("src/main/resources/assets/enemy_skeleton_32.png")

    fun checkAnimState(d: Vector2)
    {
        if (d.x() != 0f || d.y() != 0f && animator.currentAnimation != animator.moving) {
            animator.setAnimationState(AnimationEnums.WALKING)
            if (d.x() < 0) {
                animator.direction = AnimationDirection.LEFT
            } else { animator.direction = AnimationDirection.RIGHT }
        } else { animator.setAnimationState(AnimationEnums.STANDING) }
    }

    override fun update(lockScroll: Vector2, time: Float)
    {
        p.x(p.x() - lockScroll.x())
        p.y(p.y() - lockScroll.y())

        direction = Vector2Subtract(playerL, p);
        direction = Vector2Normalize(direction)
        direction.x(direction.x() * (speed.x() * time))
        direction.y(direction.y() * (speed.y() * time))
        checkAnimState(direction)
        p = Vector2Add(p, direction)

        blockPos.x(0.0f).y(0.0f)
    }

    override fun draw()
    {
        animator.animate(drawBox())
    }
}