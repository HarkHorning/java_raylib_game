package harkhorning.Core.Managers

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.Core.InitRoot
import harkhorning.Physics.Creature.Creature
import harkhorning.Physics.Creature.Player.Player

class EntityM() {

    var pos: Raylib.Vector2 = Raylib.Vector2().x(100.0f).y(80.0f)
    var enemy1: Creature = Creature(pos, 16.0f, 32.0f, 32.0f)
    var pos2: Raylib.Vector2 = Raylib.Vector2().x(620.0f).y(580.0f)
    var enemy2: Creature = Creature(pos2, 16.0f, 32.0f, 32.0f)
    val enemyList = mutableListOf<Creature>()

    var playerPos: Raylib.Vector2 = Raylib.Vector2()
        .x(GetScreenWidth() / 2.0f)
        .y(GetScreenHeight() / 2.0f)
    var player: Player = Player(playerPos, 16.0f, 32.0f, 32.0f)

    init {
        enemyList.add(enemy1)
        enemyList.add(enemy2)
    }

    fun forEachEntity(locked : Raylib.Vector2)
    {
        for (i in 0..enemyList.size - 1) {
            enemyList[i].update(locked)
            enemyList[i].blockPos.x(0.0f).y(0.0f)
            enemyList[i].checkGroundCollision(player.groundCollisionRect(), player.p)
        }

        player.update(locked)
    }

    fun drawEachEntity()
    {
        for (i in 0..enemyList.size - 1) {
            enemyList[i].drawAreas()
        }
        player.draw()
    }
}
