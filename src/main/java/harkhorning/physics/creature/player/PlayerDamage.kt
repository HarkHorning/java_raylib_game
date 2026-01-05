package harkhorning.physics.creature.player

import com.raylib.Raylib
import com.raylib.Raylib.Vector2Length
import harkhorning.physics.creature.player.hud.PlayerHealth

class PlayerDamage(val playerHealth: PlayerHealth, val player: Player) {

    fun basicHit(damage: Int, power: Float) {
        if (Vector2Length(player.stagger) <= 1.0f) {
            playerHealth.health -= damage
            player.stagger = Raylib.Vector2Scale(player.stagger, power)
        }
    }
}