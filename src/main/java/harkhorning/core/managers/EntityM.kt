package harkhorning.core.managers

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.core.HardGlobalVariables
import harkhorning.core.functional.Spawner
import harkhorning.physics.creature.Creature
import harkhorning.physics.creature.player.Player

class EntityM() {

    val hC: HardGlobalVariables = HardGlobalVariables()

    var enemyList = mutableListOf<Creature>()
    val sp: Spawner = Spawner()
    val interval = 20
    var timer = 0
    var timerTwo = 0


    var playerPos: Raylib.Vector2 = Raylib.Vector2()
        .x(GetScreenWidth() / 2.0f)
        .y(GetScreenHeight() / 2.0f)
    var player: Player = Player(playerPos, 16.0f * hC.scaler, 32.0f * hC.scaler, 32.0f * hC.scaler)

    init {
        enemyList.add(player)
    }

    fun entityToEntity(e: Creature)
    {
        for (e2 in enemyList) { if (e != e2) { e.checkGroundCol(e2.groundCollisionRect(), e2.p) } }
    }

    fun altOneUpdate()
    {
        if (timer >= interval) {
            timer = 0
            enemyList.sortBy { it.p.y() }
        } else timer ++
    }

    fun altOneDraw()
    {
        if (timerTwo >= interval) {
            timerTwo = 0
            if (sp.checkForSpawn()) sp.spawnNewEnemy(enemyList) // find a better place for this
        } else timerTwo ++
    }

    fun forEachEntity(locked : Raylib.Vector2, time: Float)
    {
        val li = enemyList
        for (i in 0 until li.size) {
            li[i].update(locked, time)
            li[i].checkGroundCol(player.groundCollisionRect(), player.p)
            entityToEntity(li[i])
        }
        enemyList = li

        altOneUpdate()
    }

    fun drawEachEntity()
    {
        val li = enemyList // exists here so that deletions to not cause index errors
        for (i in 0 until li.size) {
            li[i].draw()
        }

        altOneDraw()
    }
}
