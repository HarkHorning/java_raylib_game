package harkhorning.physics.creature.enemies

import com.raylib.Colors.WHITE
import com.raylib.Raylib
import com.raylib.Raylib.DrawTexturePro
import com.raylib.Raylib.LoadTexture
import harkhorning.core.HardGlobalVariables
import harkhorning.graphics.animation.Animation
import harkhorning.graphics.animation.AnimationDirection
import harkhorning.graphics.animation.AnimationEnums
import harkhorning.graphics.animation.AnimationType

class BasicEnemyAnimator(filePath: String) {

    var sprite: Raylib.Texture? = LoadTexture(filePath)
    val standing = Animation(0, 5, 0, 1, 0.2f, 0.2f, AnimationType.REPEATING, 32)
    val moving = Animation(12, 17, 0, 1, 0.2f, 0.2f, AnimationType.REPEATING, 32)
    val stagger = Animation(18, 23, 0, 1, 0.2f, 0.2f, AnimationType.SINGLE, 32)
    val dying = Animation(6, 11, 0, 1, 0.2f, 0.2f, AnimationType.SINGLE, 32)
    var currentAnimation: Animation? = standing
    var direction: AnimationDirection = AnimationDirection.RIGHT

    fun setAnimationState(newAnimationState : AnimationEnums)
    {
        currentAnimation = when (newAnimationState) {
            AnimationEnums.STANDING -> standing
            AnimationEnums.WALKING -> moving
            AnimationEnums.STAGGER -> stagger
            AnimationEnums.DYING -> dying
        }
    }

    fun getDrawRect() : Raylib.Rectangle?
    {
        currentAnimation?.updateAnimation()
        var drawRect = currentAnimation?.animationFrame(6)
        if (direction.value == -1) drawRect?.width(-drawRect.width())
        return drawRect
    }

    fun animate(dest: Raylib.Rectangle)
    {
        DrawTexturePro(sprite, getDrawRect(), dest,
            Raylib.Vector2(), 0.0f, WHITE)
    }
}