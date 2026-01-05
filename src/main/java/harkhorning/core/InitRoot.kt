package harkhorning.core

import com.raylib.Raylib
import harkhorning.core.managers.EntityM
import harkhorning.physics.creature.player.PlayerDamage
import harkhorning.physics.creature.player.hud.PlayerHealth
import harkhorning.physics.creature.player.hud.PlayerHud
import harkhorning.physics.creature.player.PlayerMovement
import harkhorning.physics.maps.MapRunner

class InitRoot() {

    var globalShift: Raylib.Vector2 = Raylib.Vector2()
    val eM: EntityM = EntityM(this)
    val playerMovement: PlayerMovement = PlayerMovement(this, eM.player)
    val playerHud: PlayerHud = PlayerHud(this, eM.player)
    val playerDamage: PlayerDamage = PlayerDamage(playerHud.playerHealth, eM.player)
    val map: MapRunner = MapRunner()
}
