package harkhorning.core.managers

import com.raylib.Raylib
import harkhorning.Misc.TickCounter
import harkhorning.core.HardGlobalVariables
import harkhorning.physics.creature.Creature
import harkhorning.physics.creature.enemies.BasicEnemy
import kotlin.random.Random

class Spawner {

    val hC: HardGlobalVariables = HardGlobalVariables()

    var spawnTimer = 0
    var spawnInterval = 4
//    val spawnTimer: TickCounter = TickCounter(5, 1f)
    var offScreenD = 32.0f * hC.scaler

    fun rNum() : Float { return Random.Default.nextFloat() }

    fun randomSpawnLocation() : Raylib.Vector2
    {
        var x : Float = -offScreenD
        var y : Float = -offScreenD
        if (rNum() > 0.5f) {
            x = rNum() * Raylib.GetScreenWidth()
            if (rNum() > 0.5f) y = -offScreenD
        } else {
            y = rNum() * Raylib.GetScreenHeight()
            if (rNum() > 0.5f) x = offScreenD + Raylib.GetScreenWidth()
        }
        return Raylib.Vector2().x(x).y(y)
    }

    fun chooseEnemy() : Creature
    {
        return BasicEnemy(randomSpawnLocation(), 16.0f * hC.scaler, 32.0f * hC.scaler, 32.0f * hC.scaler, 1, 12f)
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
            spawnInterval = (10 * rNum()).toInt()
            return true
        }
        spawnTimer ++
        return false
    }
}