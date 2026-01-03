package harkhorning.physics.creature.player

import com.raylib.Raylib
import harkhorning.graphics.animation.Animation
import harkhorning.graphics.animation.AnimationEnums
import harkhorning.graphics.animation.AnimationType

class PlayerAnimation {
    val standing = Animation(0, 6, 0, 1, 0.2f, 0.2f, AnimationType.REPEATING)
    val walking = Animation(0, 6, 0, 1, 0.2f, 0.2f, AnimationType.REPEATING)
    val dying = Animation(0, 6, 0, 1, 0.2f, 0.2f, AnimationType.SINGLE)
    var currentAnimation: Animation? = standing

    fun setAnimationState(newAnimationState : AnimationEnums)
    {
        currentAnimation = when (newAnimationState) {
            AnimationEnums.STANDING -> standing
            AnimationEnums.WALKING -> walking
            AnimationEnums.DYING -> dying
        }
    }

    fun getDrawRect() : Raylib.Rectangle?
    {
        var drawRect = currentAnimation?.animationFrame(6)
        return drawRect
    }
}
