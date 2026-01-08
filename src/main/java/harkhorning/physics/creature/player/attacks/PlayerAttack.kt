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
        for (spawner in attackSpawners) {

            if (eM.enemyList.size > 1 && eM.nearestEnemy != null) {
                val a: BasicAttack? = when (spawner.attackType) {
                    AttackType.NEAREST -> spawner.check(attackFrequency, eM.nearestEnemy!!.p, null)
                    AttackType.RANDOM -> spawner.check(attackFrequency, null, null)
                    AttackType.FROM_ENEMY_LIST -> spawner.check(attackFrequency, null, eM.enemyList)
                }

                if (a != null) { attacks.add(a) }
            }
        }
    }
}