package harkhorning.core

import com.raylib.Raylib
import harkhorning.core.managers.EntityM
import harkhorning.physics.creature.player.PlayerMovement
import harkhorning.physics.Map.MapRunner

class InitRoot() {

    var globalShift: Raylib.Vector2 = Raylib.Vector2()
    val eM: EntityM = EntityM()
    val playerMovement: PlayerMovement = PlayerMovement(this, eM.player)
    val map: MapRunner = MapRunner()
}
