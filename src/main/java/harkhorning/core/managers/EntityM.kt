package harkhorning.core.managers

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.core.HardGlobalVariables
import harkhorning.core.InitRoot
import harkhorning.physics.creature.Creature
import harkhorning.physics.creature.player.Player
import harkhorning.Misc.TickCounter
import harkhorning.physics.creature.player.attacks.PlayerAttack

class EntityM(val root: InitRoot) {

    val hC: HardGlobalVariables = HardGlobalVariables()
    var enemyList = mutableListOf<Creature>()
    val sp: Spawner = Spawner()
    var updateTickCrounter: TickCounter = TickCounter(1, 0f)
    var nearestEnemy: Creature? = null

    val attack = PlayerAttack(this)
    var playerPos: Raylib.Vector2 = Raylib.Vector2()
            .x(GetScreenWidth() / 2.0f).y(GetScreenHeight() / 2.0f)

    var player: Player = Player(
            playerPos, 16.0f * hC.scaler, 32.0f * hC.scaler, 32.0f * hC.scaler,
            0, 0f,
            root.s, attack)

    val attackM: AttackM = AttackM(player.playerAttack)

    init {
        enemyList.add(player)
    }

    fun getNearest(e: Creature)
    {
        if (e !is Player) { // clean this later
            attackM.checkForHit(e)
            if (nearestEnemy != null) {
                if (nearestEnemy!!.distanceTo(player.p) > e.distanceTo(player.p)) { nearestEnemy = e }
            } else { nearestEnemy = e }
        }
    }

    fun entityToEntity(e: Creature)
    {
        for (e2 in enemyList) {
            if (e != e2 && e.checkGroundCol(e2.groundCollisionRect(), e2.p)
                && e is Player)
            {
                e2.canInteractWithPlayer = true
                root.playerDamage.basicHit(e2.damage, e2.power)
            }
        }
    }

    fun forEachEntity(locked : Raylib.Vector2, time: Float)
    {
        val li = enemyList
        var kill: Creature? = null
        for (i in 0 until li.size) {
            li[i].update(locked, time)
            entityToEntity(li[i])
            getNearest(li[i])
            if (li[i].dead) kill = li[i]
        }
        enemyList.remove(kill)
        enemyList = li

        if (updateTickCrounter.increment()) {
            enemyList.sortBy { it.p.y() } // sort entities by draw order
            if (sp.checkForSpawn()) sp.spawnNewEnemy(enemyList) // check for and spawn new enemy
        }
        attackM.update(locked)
    }

    fun drawEachEntity()
    {
        val li = enemyList // exists here so that deletions to not cause index errors
        for (i in 0 until li.size) {
            li[i].draw()
        }
        attackM.draw()
    }
}
