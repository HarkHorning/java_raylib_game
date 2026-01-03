package harkhorning.core.functional

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.physics.creature.Creature
import kotlin.random.Random

class Spawner {

    var spawnTimer = 0
    var spawnInterval = 20
    var offScreenD = 32.0f

    fun rNum() : Float { return Random.nextFloat() }

    fun randomSpawnLocation() : Raylib.Vector2
    {
        var x : Float = -offScreenD
        var y : Float = -offScreenD
        if (rNum() > 0.5f) {
            x = rNum() * GetScreenWidth()
            if (rNum() > 0.5f) y = -offScreenD
        } else {
            y = rNum() * GetScreenHeight()
            if (rNum() > 0.5f) x = offScreenD + GetScreenWidth()
        }
        return Raylib.Vector2().x(x).y(y)
    }

    fun chooseEnemy() : Creature
    {
        return Creature(randomSpawnLocation(), 16.0f, 32.0f, 32.0f)
    }

    fun spawnNewEnemy(l: MutableList<Creature>) : MutableList<Creature>
    {
        val nL: MutableList<Creature> = l
        nL.add(chooseEnemy())
        return nL
    }

    fun checkForSpawn() : Boolean
    {
        if (spawnTimer >= spawnInterval) {
            spawnTimer = 0
            spawnInterval = (100 * rNum()).toInt()
            return true
        }
        spawnTimer ++
        return false
    }
}
