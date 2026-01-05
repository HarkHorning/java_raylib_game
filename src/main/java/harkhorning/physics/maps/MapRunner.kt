package harkhorning.physics.maps

import com.raylib.Colors.WHITE
import com.raylib.Raylib
import com.raylib.Raylib.DrawTexturePro
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import com.raylib.Raylib.LoadTexture
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Scale
import harkhorning.core.HardGlobalVariables

class MapRunner {

    val hC: HardGlobalVariables = HardGlobalVariables()

    var mapSprite: Raylib.Texture? = LoadTexture("src/main/resources/assets/grass_basic_32.png")
    var cols: Int
    var rows: Int
    var tileD: Vector2 = Vector2().x(32.0f * hC.scaler.toFloat()).y(16.0f * hC.scaler.toFloat())
    var mapXY: Vector2 = Vector2()
    var mapI: Vector2 = Vector2()
    var dest = Raylib.Rectangle()
        .x(0f)
        .y(0f)
        .width(tileD.x())
        .height(tileD.y())

    init {
        cols = GetScreenWidth() / tileD.x().toInt()
        rows = (GetScreenHeight() / tileD.y().toInt()) + 1
    }

    fun getDrawArea() : Raylib.Rectangle
    {
        val rect = Raylib.Rectangle()
            .x(0f)
            .y(0f)
            .width(32f)
            .height(16f)
        return rect
    }

    fun updateMap(locked : Vector2)
    {
        val negLock: Vector2 = Vector2Scale(locked, -1.0f);
        mapXY = Vector2Add(mapXY, negLock) // might need to change this

        if (mapXY.x() >=0) {
            mapXY.x(mapXY.x() - tileD.x())
        } else if (mapXY.x() <-tileD.x()) {
            mapXY.x(mapXY.x() + tileD.x())
        }

        if (mapXY.y() >=0) {
            mapXY.y(mapXY.y() - tileD.y())
        } else if (mapXY.y() <-tileD.y()) {
            mapXY.y(mapXY.y() + tileD.y())
        }
    }

    fun drawMap()
    {
        for (i in 0..cols) {

            dest.x(mapXY.x() + (i * tileD.x()).toInt())

            for (j in 0..rows) {

                dest.y(mapXY.y() + (j * tileD.y()).toInt())

                DrawTexturePro(
                    mapSprite,
                    getDrawArea(),
                    dest,
                    Vector2(),
                    0.0f,
                    WHITE
                )
            }
        }
    }
}
