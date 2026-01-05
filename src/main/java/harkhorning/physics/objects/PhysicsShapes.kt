package harkhorning.physics.objects

import com.raylib.Colors.*
import com.raylib.Raylib.Vector2
import com.raylib.Raylib.Rectangle
import com.raylib.Raylib.DrawRectangleRec

abstract class PhysicsShapes(var p: Vector2, var r: Float, var h: Float, var w: Float)
{

    fun drawBox() : Rectangle
    { // area sprite is drawn on
        return Rectangle()
            .x(p.x() - r)
            .y(p.y() - r)
            .width(w)
            .height(h)
    }

    fun groundCollisionRect(): Rectangle
    { // area that detects object movement collisions
        return Rectangle()
            .x(p.x() - r)
            .y(p.y() + r / 2)
            .width(w)
            .height(r)
    }

    fun hitCollisionRect(): Rectangle
    { // the hit box by which other creatures are hit
        return Rectangle()
            .x(p.x() - r + r / 2)
            .y(p.y() - r)
            .width(r)
            .height(h)
    }

    fun drawAreas()
    { // see the shapes of your object
        DrawRectangleRec(drawBox(), YELLOW);
        DrawRectangleRec(groundCollisionRect(), PINK);
        DrawRectangleRec(hitCollisionRect(), ORANGE);
    }
}
