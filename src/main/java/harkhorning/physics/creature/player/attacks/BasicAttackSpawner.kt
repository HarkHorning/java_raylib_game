package harkhorning.physics.creature.player.attacks

import com.raylib.Raylib
import harkhorning.Misc.TickCounter
import harkhorning.physics.creature.Creature
import harkhorning.physics.projectile.BasicAttack

class BasicAttackSpawner {

    val increment = TickCounter(4, 1f)
    val attackType: AttackType = AttackType.NEAREST

    fun check(inc: Float, nearest: Raylib.Vector2?, enemyList: MutableList<Creature>?) : BasicAttack?
    {
        if (increment.increment(inc) && nearest != null) {
            return BasicAttack(nearest)
        }
        return null
    }
}