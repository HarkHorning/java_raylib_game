package harkhorning.physics.projectile

import com.raylib.Colors.WHITE
import com.raylib.Raylib
import com.raylib.Raylib.*
import harkhorning.core.HardGlobalVariables
import harkhorning.graphics.animation.Animation
import harkhorning.graphics.animation.AnimationType
import java.lang.Math.toDegrees
import kotlin.math.atan2

class BasicAttack(val targetP: Vector2) {

    var p: Vector2 = Vector2()
    var direction: Vector2 = Vector2()
    val speed: Vector2 = Vector2().x(500f).y(480f)
    val hC = HardGlobalVariables()
    val radius: Vector2 = Vector2().x(8f * hC.scaler).y(8f * hC.scaler)
    val damage: Float = 1f
    val power: Float = 12f
    val animation: Animation = Animation(0, 3, 0, 1, 0.2f, 0.2f,
            AnimationType.REPEATING, 32)
    var drawRect: Rectangle? = Rectangle()
    var sprite: Texture? = LoadTexture("src/main/resources/assets/magic_missile.png")
    var angleDeg: Float = 0f

    init {

        p.x((GetScreenWidth() / 2).toFloat()).y((GetScreenHeight() / 2 - 4f * hC.scaler))
        direction = Vector2Subtract(targetP, p)
        direction = Vector2Normalize(direction)
        direction.x(direction.x() * (speed.x() * GetFrameTime()))
        direction.y(direction.y() * (speed.y() * GetFrameTime()))

        angleDeg = getAngle()

        println("YOUR ANGLE IS: $angleDeg")
    }

    fun getAngle(): Float {

        val delta = Vector2Subtract(targetP, p)
        val radians = atan2(delta.y(), delta.x())
        val angleDegrees = radians * RAD2DEG

        return angleDegrees.toFloat()
    }

    fun getCollisionRect() : Raylib.Rectangle
    {
        return Raylib.Rectangle().x(p.x() - radius.x()).y(p.y() - radius.y()).width(radius.x() * 2).height(radius.y() * 2)
    }

    fun update(lockScroll: Raylib.Vector2)
    {
        animation.updateAnimation()
        drawRect = animation.animationFrame(4)

        p.x(p.x() - lockScroll.x())
        p.y(p.y() - lockScroll.y())
        p = Vector2Add(p, direction)
    }

    fun draw()
    {
//        Raylib.DrawRectangleRec(getCollisionRect(), PINK)
        val origin = Raylib.Vector2()
        DrawTexturePro(sprite, drawRect, getCollisionRect(),
            origin, angleDeg.toFloat(), WHITE)
    }
}