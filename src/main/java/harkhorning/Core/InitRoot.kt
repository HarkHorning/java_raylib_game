package harkhorning.Core

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.Physics.Creature.Creature
import harkhorning.Physics.Creature.Player.Player
import harkhorning.Physics.Creature.Player.PlayerMovement

class InitRoot {

    var GLOBAL_SHIFT: Raylib.Vector2 = Raylib.Vector2();

    var playerMovement: PlayerMovement = PlayerMovement(this);

    var pos: Raylib.Vector2 = Raylib.Vector2().x(100.0f).y(80.0f)
    var physicsShapes: Creature = Creature(pos, 16.0f, 32.0f, 32.0f)

    var playerPos: Raylib.Vector2 = Raylib.Vector2()
        .x(GetScreenWidth() / 2.0f)
        .y(GetScreenHeight() / 2.0f)
    var player: Player = Player(playerPos, 16.0f, 32.0f, 32.0f)
}
