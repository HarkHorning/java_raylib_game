package harkhorning.Physics.Creature.Player

import com.raylib.Raylib.IsKeyDown
import com.raylib.Raylib.IsKeyPressed
import com.raylib.Raylib.KEY_D
import com.raylib.Raylib.Vector2
import harkhorning.Physics.Creature.Creature

class Player(p: Vector2, r: Float, h: Float, w: Float) : Creature(p, r, h, w)
{

    override fun update(lockScroll: Vector2)
    {

    }

    override fun draw()
    {
        drawAreas()
    }
}
