package harkhorning.Core.Updates

import com.raylib.Raylib
import harkhorning.Core.InitRoot
import harkhorning.Physics.Creature.Creature

class UpdateRoot(var r: InitRoot) {

    var pos: Raylib.Vector2 = Raylib.Vector2().x(100.0f).y(80.0f)
    var enemy1: Creature = Creature(pos, 16.0f, 32.0f, 32.0f)
    var pos2: Raylib.Vector2 = Raylib.Vector2().x(620.0f).y(580.0f)
    var enemy2: Creature = Creature(pos2, 16.0f, 32.0f, 32.0f)
    init {
        r.addEnemy(enemy1)
        r.addEnemy(enemy2)
    }

    fun update() {
        r.playerMovement.check()
        val locked: Raylib.Vector2 = r.GLOBAL_SHIFT

        // this will be in enemy manager
        for (i in 0..r.enemyList.size - 1) {
            r.enemyList[i].update(locked)
            r.enemyList[i].blockPos.x(0.0f).y(0.0f)
            r.enemyList[i].checkGroundCollision(r.player.groundCollisionRect(), r.player.p)
        }

        r.player.update(locked)
    }
}
