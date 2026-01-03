package harkhorning.physics.creature.player

import com.raylib.Colors.WHITE
import com.raylib.Raylib
import com.raylib.Raylib.DrawTexturePro
import com.raylib.Raylib.LoadTexture
import harkhorning.graphics.animation.Animation
import harkhorning.graphics.animation.AnimationEnums
import harkhorning.graphics.animation.AnimationType

class PlayerAnimation {

    var sprite = LoadTexture("src/main/resources/assets/char_gnome_32.png")
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
        currentAnimation?.updateAnimation()
        var drawRect = currentAnimation?.animationFrame(6)
        return drawRect
    }

    fun animate(dest: Raylib.Rectangle)
    {
        val origin = Raylib.Vector2()
        DrawTexturePro(sprite, getDrawRect(), dest,
            origin as Raylib.Vector2?, 0.0f, WHITE);
    }
}
