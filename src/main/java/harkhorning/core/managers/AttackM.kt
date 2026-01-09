package harkhorning.core.managers

import com.raylib.Raylib
import harkhorning.physics.creature.Creature
import harkhorning.physics.creature.player.attacks.PlayerAttack
import harkhorning.physics.projectile.BasicAttack

class AttackM(val playerAttack: PlayerAttack) {

    fun update(scroll: Raylib.Vector2)
    {
        playerAttack.update()
        for (attack in playerAttack.attacks) {
            attack.update(scroll)
        }
    }

    fun checkForHit(e: Creature): Boolean
    {
        val attacks: MutableList<BasicAttack> = playerAttack.attacks
        var boo = false
        var markedForDeletion: BasicAttack? = null

        for (attack in attacks) {
            if (e.checkHit(attack.getCollisionRect(), attack.p, attack.direction, attack.power, attack.damage)) {
                markedForDeletion = attack
            }
        }

        attacks.remove(markedForDeletion)
        playerAttack.attacks = attacks
        return boo
    }

    fun draw()
    {
        val attacks: MutableList<BasicAttack> = playerAttack.attacks
        for (attack in attacks) {
            attack.draw()
        }
    }
}