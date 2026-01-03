package harkhorning.core.managers

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.core.functional.Spawner
import harkhorning.physics.creature.Creature
import harkhorning.physics.creature.player.Player

class EntityM() {

    val enemyList = mutableListOf<Creature>()
    val sp: Spawner = Spawner()

    var playerPos: Raylib.Vector2 = Raylib.Vector2()
        .x(GetScreenWidth() / 2.0f)
        .y(GetScreenHeight() / 2.0f)
    var player: Player = Player(playerPos, 16.0f, 32.0f, 32.0f)

    init {
        enemyList.add(player)
    }

    fun entityToEntity(e: Creature)
    {
        for (e2 in enemyList) { if (e != e2) { e.checkGroundCol(e2.groundCollisionRect(), e2.p) } }
    }

    fun forEachEntity(locked : Raylib.Vector2)
    {
        for (e in enemyList) {
            e.update(locked)
            e.checkGroundCol(player.groundCollisionRect(), player.p)
            entityToEntity(e)
            e.updateDrawOrder()
        }

        enemyList.sortedByDescending { it.drawPlacement }

        if (sp.checkForSpawn()) sp.spawnNewEnemy(enemyList) // find a better place for this
    }

    fun drawEachEntity()
    {
        for (e in enemyList) {
            e.draw()
        }
    }
}
