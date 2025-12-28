package harkhorning.Physics.Map

import com.raylib.Colors.DARKGRAY
import com.raylib.Raylib
import com.raylib.Raylib.GetScreenHeight
import com.raylib.Raylib.GetScreenWidth
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Vector2Add
import com.raylib.Raylib.Vector2Scale

class MapRunner {

    var cols: Int = 30
    var rows: Int = 33
    var tileD: Vector2 = Vector2().x(32.0f).y(16.0f)
    var mapXY: Vector2 = Vector2()
    var mapI: Vector2 = Vector2()
    var fixedMapXY: Vector2 = Vector2()
    var fixedMapI: Vector2 = Vector2()

    init {
        cols = GetScreenWidth() / 32
        rows = GetScreenHeight() / 16
    }

    fun updateMap(locked : Raylib.Vector2)
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

    fun drawMap(locked : Raylib.Vector2)
    {
        for (i in 0..cols) {
            for (j in 0..rows) {
                Raylib.DrawRectangleLines(
                    (mapXY.x().toInt() + (i * tileD.x())).toInt(),
                    mapXY.y().toInt() + (j * tileD.y()).toInt(),
                    tileD.x().toInt(),
                    tileD.y().toInt(),
                    DARKGRAY)
            }
        }
    }
}
