package harkhorning.Misc

import com.raylib.Raylib.GetFrameTime

class TickCounter(val interval: Int, var increment: Float) {

    fun increment(): Boolean
    {
        if (increment > interval) {
            increment = 0f
            return true
        }
        increment += 1f * GetFrameTime()
        return false
    }
}