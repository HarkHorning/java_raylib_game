package harkhorning.physics.creature.player

import com.raylib.Colors.WHITE
import com.raylib.Raylib
import com.raylib.Raylib.DrawTexturePro
import com.raylib.Raylib.LoadImage
import com.raylib.Raylib.LoadTexture
import harkhorning.core.HardGlobalVariables
import harkhorning.graphics.animation.Animation
import harkhorning.graphics.animation.AnimationDirection
import harkhorning.graphics.animation.AnimationEnums
import harkhorning.graphics.animation.AnimationType

class PlayerAnimation {

    var sprite: Raylib.Texture? = LoadTexture("src/main/resources/assets/char_gnome_32.png")
    val standing = Animation(0, 5, 0, 1, 0.2f, 0.2f, AnimationType.REPEATING, 32)
    val walking = Animation(12, 17, 0, 1, 0.2f, 0.2f, AnimationType.REPEATING, 32)
    val stagger = Animation(18, 23, 0, 1, 0.2f, 0.2f, AnimationType.REPEATING, 32)
    val dying = Animation(6, 11, 0, 1, 0.2f, 0.2f, AnimationType.SINGLE, 32)
    var currentAnimation: Animation? = standing
    var direction: AnimationDirection = AnimationDirection.RIGHT

    fun setAnimationState(newAnimationState : AnimationEnums)
    {
        currentAnimation = when (newAnimationState) {
            AnimationEnums.STANDING -> standing
            AnimationEnums.WALKING -> walking
            AnimationEnums.STAGGER -> stagger
            AnimationEnums.DYING -> dying
        }
    }

    fun getDrawRect() : Raylib.Rectangle?
    {
        currentAnimation?.updateAnimation()
        val drawRect = currentAnimation?.animationFrame(6)
        if (direction.value == -1) drawRect?.width(-drawRect.width())
        return drawRect
    }

    fun animate(dest: Raylib.Rectangle)
    {
        val origin = Raylib.Vector2()
        DrawTexturePro(sprite, getDrawRect(), dest,
            origin as Raylib.Vector2?, 0.0f, WHITE)
    }
}
