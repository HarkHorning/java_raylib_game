package harkhorning.graphics.animation

import com.raylib.Raylib
import com.raylib.Raylib.GetFrameTime

class Animation(val start: Int,
                val end: Int,
                var current: Int,
                var step: Int,
                var speed: Float,
                var remaining: Float,
                var type: AnimationType,
                var spriteSpan: Int)
{

    fun updateAnimation()
    {
        val dt = GetFrameTime()
        remaining -= dt

        if (remaining <= 0.0) {
            remaining = speed
            current += step

            if (current > end) {
                current = when (type) {
                    AnimationType.REPEATING -> start
                    AnimationType.SINGLE -> end
                }
            }
            else if (current < start) {
                current = when (type) {
                    AnimationType.REPEATING -> end
                    AnimationType.SINGLE -> start
                }
            }
        }
    }

    fun animationFrame(numFramesPerRow : Int) : Raylib.Rectangle
    {
        val x = (current % numFramesPerRow) * spriteSpan
        val y = (current / numFramesPerRow) * spriteSpan
        val r : Raylib.Rectangle = Raylib.Rectangle()
                        .x(x.toFloat())
                        .y(y.toFloat())
                        .width(spriteSpan.toFloat())
                        .height(spriteSpan.toFloat())

        return r
    }
}
