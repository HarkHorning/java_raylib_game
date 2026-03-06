package harkhorning.Misc

import com.raylib.Raylib.GetFrameTime

class TickCounter(var interval: Int, var increment: Float) {

    fun increment(): Boolean
    {
        if (increment > interval) {
            increment = 0f
            return true
        }
        increment += 1f * GetFrameTime()
        return false
    }

    fun increment(inc: Float): Boolean
    {
        if (increment > interval) {
            increment = 0f
            return true
        }
        increment += inc * GetFrameTime()
        return false
    }
}