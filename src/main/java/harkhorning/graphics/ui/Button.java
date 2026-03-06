package harkhorning.graphics.ui;
//package harkhorning.graphics.ui;


import com.raylib.Raylib;
import harkhorning.core.HardGlobalVariables;
import harkhorning.state.State;
import harkhorning.state.StateMachine;

import static com.raylib.Colors.GRAY;
import static com.raylib.Colors.LIGHTGRAY;
import static com.raylib.Raylib.*;

public class Button implements ButtonInterface {

    HardGlobalVariables hC = new HardGlobalVariables();
    StateMachine s;
    String text;
    int size;
    State statePotential;
    Raylib.Vector2 p, p2;
    Raylib.Rectangle rect;
    boolean selected;

    public Button(StateMachine s, String t, State sP, int size, float x, int i, int pad)
    {
        this.s = s;
        this.text = t;
        this.size = size;
        this.statePotential = sP;
        Font defaultFont = GetFontDefault();
        Vector2 textD = MeasureTextEx(defaultFont, t, this.size, 2);
        int textSize = Raylib.MeasureText(text, this.size);
        p = new Raylib.Vector2().x(x - (float)(textSize / 2)).y(i * 64 + 140.0f * hC.getScaler());
        rect = new Rectangle()
            .x(p.x() - pad)
            .y(p.y() - pad)
            .width(textD.x() + pad * 2)
            .height(textD.y() + pad * 2);
    }

    @Override
    public void OnClick()
    {
        s.NewGameState(statePotential);
    }
    @Override
    public void MouseOver()
    {
        if (CheckCollisionPointRec(GetMousePosition(), rect)) {
            selected = true;
            if (IsMouseButtonReleased(MOUSE_BUTTON_LEFT)) {
                OnClick();
            }
        } else selected = false;
    }
    @Override
    public void DrawButton()
    {
        if (selected) {
            Raylib.DrawRectangleLinesEx(rect, 4.0f, LIGHTGRAY);
        }
        Raylib.DrawText(text, (int)p.x(), (int)p.y(), size, LIGHTGRAY);
    }
}
