package harkhorning.core.managers

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.core.HardGlobalVariables
import harkhorning.core.InitRoot
import harkhorning.physics.creature.Creature
import harkhorning.physics.creature.player.Player
import harkhorning.Misc.TickCounter

class EntityM(val root: InitRoot) {

    val hC: HardGlobalVariables = HardGlobalVariables()
    var enemyList = mutableListOf<Creature>()
    val sp: Spawner = Spawner()
    var nearestEnemy: Creature? = null
    var updateTickCrounter: TickCounter = TickCounter(1, 0f)

    var playerPos: Raylib.Vector2 = Raylib.Vector2()
                            .x(GetScreenWidth() / 2.0f)
                            .y(GetScreenHeight() / 2.0f)
    var player: Player = Player(
            playerPos,
            16.0f * hC.scaler,
            32.0f * hC.scaler,
            32.0f * hC.scaler,
            0,
            0f,
            root.s)

    init {
        enemyList.add(player)
    }

    fun entityToEntity(e: Creature)
    {
        for (e2 in enemyList) {
            if (e != e2 && e.checkGroundCol(e2.groundCollisionRect(), e2.p))
            {
                if (e is Player) {
                    e2.canInteractWithPlayer = true
                    root.playerDamage.basicHit(e2.damage, e2.power)
                }
            }
        }
    }

    fun forEachEntity(locked : Raylib.Vector2, time: Float)
    {
        val li = enemyList
        for (i in 0 until li.size) {
            li[i].update(locked, time)
            entityToEntity(li[i])
            if (nearestEnemy != null && nearestEnemy!!.distanceTo(player.p) > li[i].distanceTo(player.p)) {
                nearestEnemy = li[i]
            }
        }
        enemyList = li

        if (updateTickCrounter.increment()) {
            enemyList.sortBy { it.p.y() } // sort entities by draw order
            if (sp.checkForSpawn()) sp.spawnNewEnemy(enemyList) // check for and spawn new enemy
        }
    }

    fun drawEachEntity()
    {
        val li = enemyList // exists here so that deletions to not cause index errors
        for (i in 0 until li.size) {
            li[i].draw()
        }
    }
}
