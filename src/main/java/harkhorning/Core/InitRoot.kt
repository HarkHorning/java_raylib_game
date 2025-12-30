package harkhorning.Core

import com.raylib.Raylib
import harkhorning.Core.Managers.EntityM
import harkhorning.Physics.Creature.Player.PlayerMovement
import harkhorning.Physics.Map.MapRunner

class InitRoot() {

    var GLOBAL_SHIFT: Raylib.Vector2 = Raylib.Vector2()
    val eM: EntityM = EntityM()
    val playerMovement: PlayerMovement = PlayerMovement(this, eM.player)
    val map: MapRunner = MapRunner()
}
