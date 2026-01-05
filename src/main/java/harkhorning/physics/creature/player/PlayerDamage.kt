package harkhorning.physics.creature.player

import com.raylib.Raylib
import harkhorning.physics.creature.player.hud.PlayerHealth

class PlayerDamage(val playerHealth: PlayerHealth, val player: Player) {

    fun basicHit(damage: Int, power: Float) {
        playerHealth.health -= damage
        player.stagger = Raylib.Vector2Scale(player.stagger, power)
    }
}