package harkhorning.Core

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.Physics.Creature.Creature
import harkhorning.Physics.Creature.Player.Player
import harkhorning.Physics.Creature.Player.PlayerMovement

class InitRoot() {

    var GLOBAL_SHIFT: Raylib.Vector2 = Raylib.Vector2()
    val enemyList = mutableListOf<Creature>()

    var playerPos: Raylib.Vector2 = Raylib.Vector2()
        .x(GetScreenWidth() / 2.0f)
        .y(GetScreenHeight() / 2.0f)
    var player: Player = Player(playerPos, 16.0f, 32.0f, 32.0f)
    val playerMovement: PlayerMovement = PlayerMovement(this, player)

    fun addEnemy(e: Creature) { enemyList.add(e) }
}
