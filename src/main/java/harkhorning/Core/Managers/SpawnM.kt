package harkhorning.Core.Managers

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.Physics.Creature.Creature
import kotlin.collections.mutableListOf

class SpawnM {

    fun randomSpawnLocation() : Raylib.Vector2
    {
        return Raylib.Vector2().x(GetScreenWidth() / 2.0f).y(GetScreenHeight() / 2.0f)
    }

    fun chooseEnemy() : Creature
    {
        return Creature(randomSpawnLocation(), 16.0f, 32.0f, 32.0f)
    }

    fun spawnNewEnemy(l: MutableList<Creature>) : MutableList<Creature>
    {
        var nL: MutableList<Creature> = l

        return nL
    }
}
