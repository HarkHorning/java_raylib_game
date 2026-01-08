package harkhorning.physics.creature.player.attacks

import harkhorning.core.managers.EntityM
import harkhorning.physics.projectile.BasicAttack

class PlayerAttack(val eM: EntityM) {

    var attackFrequency: Float = 1f
    var basicAttackSpawner = BasicAttackSpawner()
    val attackSpawners = mutableListOf<BasicAttackSpawner>()
    var attacks = mutableListOf<BasicAttack>()

    init {
        attackSpawners.add(basicAttackSpawner)
    }

    fun update()
    {
        for (attack in attackSpawners) {
            if (eM.enemyList.size > 1 && eM.nearestEnemy != null) {
                val a: BasicAttack? = attack.check(attackFrequency, eM.nearestEnemy!!.p)
                if (a != null) {
                    attacks.add(a)
                }
            }
        }
    }
}