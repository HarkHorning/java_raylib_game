package harkhorning.core.functional

import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import harkhorning.core.HardGlobalVariables
import harkhorning.physics.creature.Creature
import harkhorning.physics.creature.enemies.BasicEnemy
import kotlin.random.Random

class Spawner {

    val hC: HardGlobalVariables = HardGlobalVariables()

    var spawnTimer = 0
    var spawnInterval = 10
    var offScreenD = 32.0f * hC.scaler

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
        return BasicEnemy(randomSpawnLocation(), 16.0f * hC.scaler, 32.0f * hC.scaler, 32.0f * hC.scaler)
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
            spawnInterval = (80 * rNum()).toInt()
            return true
        }
        spawnTimer ++
        return false
    }
}
