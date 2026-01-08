package harkhorning.physics.creature.player.attacks

import com.raylib.Raylib
import harkhorning.Misc.TickCounter
import harkhorning.physics.projectile.BasicAttack

class BasicAttackSpawner {
    val increment = TickCounter(4, 1f)

    fun check(inc: Float, nearest: Raylib.Vector2) : BasicAttack?
    {
        if (increment.increment(inc)) {
            System.out.println("SPAWN BASIC ATTACK")
            return BasicAttack(nearest)
        }
        return null
    }
}