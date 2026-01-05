package harkhorning.physics.creature.player

import com.raylib.Raylib.Vector2
import com.raylib.Raylib.IsKeyDown
import com.raylib.Raylib.KEY_A
import com.raylib.Raylib.KEY_D
import com.raylib.Raylib.KEY_S
import com.raylib.Raylib.KEY_W
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Normalize
import harkhorning.core.InitRoot
import harkhorning.graphics.animation.AnimationDirection
import harkhorning.graphics.animation.AnimationEnums

class PlayerMovement(val root: InitRoot, val player: Player) {

    var inputM: Vector2 = Vector2()
    var playerSpeed: Vector2 = Vector2().x(400.0f).y(200.0f)

    fun normalize(time: Float)
    {
        if (inputM.x() != 0.0f || inputM.y() != 0.0f) {player.animations.setAnimationState(AnimationEnums.WALKING)}
        else {player.animations.setAnimationState(AnimationEnums.STANDING)}
        inputM = Vector2Normalize(inputM)
        root.globalShift.x(inputM.x() * playerSpeed.x() * time)
        root.globalShift.y(inputM.y() * playerSpeed.y() * time)
        root.globalShift = Vector2Add(root.globalShift, player.stagger)
    }

    fun check(time: Float)
    {
        if (IsKeyDown(KEY_D) && player.blockPos.x() >= 0.0f) {
            inputM.x(1.0f)
            if (player.animations.direction != AnimationDirection.RIGHT) player.animations.direction = AnimationDirection.RIGHT
        } else if (IsKeyDown(KEY_A) && player.blockPos.x() <= 0.0f) {
            inputM.x(-1.0f)
            if (player.animations.direction != AnimationDirection.LEFT) player.animations.direction = AnimationDirection.LEFT
        } else {
            root.globalShift.x(0.0f)
            inputM.x(0.0f)
        }

        if (IsKeyDown(KEY_S) && player.blockPos.y() >= 0.0f) { inputM.y(1.0f) }
        else if (IsKeyDown(KEY_W) && player.blockPos.y() <= 0.0f) { inputM.y(-1.0f) }
        else {
            root.globalShift.y(0.0f)
            inputM.y(0.0f)
        }
        normalize(time)
    }
}
